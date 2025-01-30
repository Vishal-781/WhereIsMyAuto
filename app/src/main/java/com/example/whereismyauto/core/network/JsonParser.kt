package com.example.whereismyauto.core.network

import com.google.gson.Gson


// core/network/JsonParser.kt
interface JsonParser {
    fun <T> fromJson(json: String, typeToken: TypeToken<T>): T
    fun <T> toJson(obj: T): String
}

class GsonParser(private val gson: Gson = Gson()) : JsonParser {
    override fun <T> fromJson(json: String, typeToken: TypeToken<T>): T {
        return gson.fromJson(json, typeToken.type)
    }

    override fun <T> toJson(obj: T): String {
        return gson.toJson(obj)
    }
}