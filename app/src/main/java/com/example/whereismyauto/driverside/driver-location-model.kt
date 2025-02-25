/**
 * Data model for driver location
 */
data class DriverLocation(
    val driverId: String,
    val latitude: Double,
    val longitude: Double,
    val timestamp: Long,
    val speed: Float = 0f,
    val heading: Float = 0f,
    val status: DriverStatus = DriverStatus.AVAILABLE
)

/**
 * Driver status enum
 */
enum class DriverStatus {
    AVAILABLE,
    BUSY,
    OFFLINE
}
