package com.example.whereismyauto.data

import android.content.Context
import android.content.SharedPreferences

enum class UserRole {
    DRIVER,
    USER
}

class UserSessionManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "user_session", Context.MODE_PRIVATE
    )
    
    companion object {
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_ROLE = "user_role"
    }
    
    /**
     * Check if user is logged in
     */
    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }
    
    /**
     * Get the logged-in user's role
     */
    fun getUserRole(): UserRole? {
        val roleString = sharedPreferences.getString(KEY_USER_ROLE, null) ?: return null
        return try {
            UserRole.valueOf(roleString)
        } catch (e: IllegalArgumentException) {
            null
        }
    }
    
    /**
     * Create login session for driver
     */
    fun createDriverSession(userId: String) {
        createSession(userId, UserRole.DRIVER)
    }
    
    /**
     * Create login session for regular user
     */
    fun createUserSession(userId: String) {
        createSession(userId, UserRole.USER)
    }
    
    /**
     * Create general session with specified role
     */
    private fun createSession(userId: String, role: UserRole) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(KEY_IS_LOGGED_IN, true)
        editor.putString(KEY_USER_ID, userId)
        editor.putString(KEY_USER_ROLE, role.name)
        editor.apply()
    }
    
    /**
     * Logout user and clear session
     */
    fun logout() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
    
    /**
     * Get user ID
     */
    fun getUserId(): String? {
        return sharedPreferences.getString(KEY_USER_ID, null)
    }
}
