/**
 * Extended Redis client interface with additional methods needed by AutoLocationApiImpl
 */
interface ExtendedRedisClient : RedisClient {
    suspend fun get(key: String): String?
    suspend fun set(key: String, value: String)
    suspend fun subscribe(channel: String, onMessage: suspend (String) -> Unit)
}
