/**
 * Interface for Redis client (to be implemented or injected)
 */
interface RedisClient {
    suspend fun setex(key: String, expireSeconds: Int, value: String)
    suspend fun publish(channel: String, message: String)
}
