import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class AutoLocationApiImpl(
    private val redisClient: RedisClient,
    private val objectMapper: ObjectMapper,
    private val coroutineScope: CoroutineScope
) : AutoLocationApi {

    // Redis key for storing auto locations
    private val AUTO_LOCATIONS_KEY = "auto:locations"
    
    // Shared flow to emit updates
    private val _autoLocationsFlow = MutableSharedFlow<List<AutoLocationDto>>(replay = 1)
    
    init {
        // Initialize with empty list and start listening for Redis updates
        coroutineScope.launch {
            _autoLocationsFlow.emit(emptyList())
            subscribeToRedisUpdates()
        }
    }
    
    override suspend fun getAutoLocations(): List<AutoLocationDto> {
        return try {
            val locationsJson = redisClient.get(AUTO_LOCATIONS_KEY) ?: "[]"
            objectMapper.readValue(locationsJson, object : TypeReference<List<AutoLocationDto>>() {})
        } catch (e: Exception) {
            println("Error fetching auto locations from Redis: ${e.message}")
            emptyList()
        }
    }

    override fun observeAutoLocations(): Flow<List<AutoLocationDto>> {
        return _autoLocationsFlow.asSharedFlow()
    }
    
    private suspend fun subscribeToRedisUpdates() {
        try {
            redisClient.subscribe(AUTO_LOCATIONS_KEY) { message ->
                coroutineScope.launch {
                    try {
                        val locations = objectMapper.readValue(
                            message, 
                            object : TypeReference<List<AutoLocationDto>>() {}
                        )
                        _autoLocationsFlow.emit(locations)
                    } catch (e: Exception) {
                        println("Error parsing Redis update: ${e.message}")
                    }
                }
            }
        } catch (e: Exception) {
            println("Error subscribing to Redis: ${e.message}")
        }
    }
    
    // Method to update locations (could be called from elsewhere in your application)
    suspend fun updateAutoLocations(locations: List<AutoLocationDto>) {
        try {
            val locationsJson = objectMapper.writeValueAsString(locations)
            redisClient.set(AUTO_LOCATIONS_KEY, locationsJson)
            _autoLocationsFlow.emit(locations)
        } catch (e: Exception) {
            println("Error updating auto locations in Redis: ${e.message}")
        }
    }
}
