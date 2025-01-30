package com.example.whereismyauto.core.network

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

abstract class TypeToken<T> {
    val type: Type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
}
