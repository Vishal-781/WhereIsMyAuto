/**
 * Interface for GPS service (to be implemented or injected)
 */
interface GpsService {
    suspend fun getCurrentLocation(): GpsLocation
}

/**
 * Data model for GPS location
 */
data class GpsLocation(
    val latitude: Double,
    val longitude: Double,
    val bearing: Float = 0f,
    val speed: Float = 0f,
    val accuracy: Float = 0f
)
