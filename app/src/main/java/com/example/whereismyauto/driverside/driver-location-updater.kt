import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.Instant
import kotlin.time.Duration.Companion.seconds

/**
 * Service to update driver locations in Redis using GPS data
 */
class DriverLocationUpdater(
    private val gpsService: GpsService,
    private val redisClient: RedisClient,
    private val objectMapper: ObjectMapper,
    private val coroutineScope: CoroutineScope,
    private val driverId: String,
    private val updateInterval: kotlin.time.Duration = 5.seconds
) {
    companion object {
        private const val DRIVER_LOCATION_KEY = "driver:location:"
        private const val DRIVER_LOCATIONS_CHANNEL = "driver:locations:updates"
        private const val LOCATION_TTL_SECONDS = 300 // 5 minutes
    }

    /**
     * Start updating driver location periodically
     */
    fun startLocationUpdates() {
        createLocationUpdateFlow()
            .onEach { location -> 
                updateLocationInRedis(location)
            }
            .catch { e -> 
                println("Error in location updates: ${e.message}")
            }
            .launchIn(coroutineScope)
    }

    /**
     * Creates a flow that emits GPS locations at regular intervals
     */
    private fun createLocationUpdateFlow(): Flow<DriverLocation> = flow {
        while (true) {
            try {
                val currentLocation = gpsService.getCurrentLocation()
                val driverLocation = DriverLocation(
                    driverId = driverId,
                    latitude = currentLocation.latitude,
                    longitude = currentLocation.longitude,
                    timestamp = Instant.now().epochSecond,
                    speed = currentLocation.speed,
                    heading = currentLocation.bearing
                )
                emit(driverLocation)
            } catch (e: Exception) {
                println("Failed to get GPS location: ${e.message}")
            }
            
            delay(updateInterval)
        }
    }

    /**
     * Updates driver location in Redis and publishes update
     */
    private suspend fun updateLocationInRedis(location: DriverLocation) {
        try {
            val locationJson = objectMapper.writeValueAsString(location)
            
            // Store individual driver location with TTL
            val driverKey = "$DRIVER_LOCATION_KEY$driverId"
            redisClient.setex(driverKey, LOCATION_TTL_SECONDS, locationJson)
            
            // Publish update to channel for real-time subscribers
            redisClient.publish(DRIVER_LOCATIONS_CHANNEL, locationJson)
            
            println("Updated location for driver $driverId: lat=${location.latitude}, lng=${location.longitude}")
        } catch (e: Exception) {
            println("Failed to update location in Redis: ${e.message}")
        }
    }

    /**
     * Force an immediate location update
     */
    suspend fun updateLocationNow() {
        try {
            val currentLocation = gpsService.getCurrentLocation()
            val driverLocation = DriverLocation(
                driverId = driverId,
                latitude = currentLocation.latitude,
                longitude = currentLocation.longitude,
                timestamp = Instant.now().epochSecond,
                speed = currentLocation.speed,
                heading = currentLocation.bearing
            )
            updateLocationInRedis(driverLocation)
        } catch (e: Exception) {
            println("Failed to update location immediately: ${e.message}")
        }
    }

    /**
     * Stop location updates
     */
    fun stopLocationUpdates() {
        // This would cancel the coroutine context
        // Implementation depends on how you manage the coroutine scope
    }
}
