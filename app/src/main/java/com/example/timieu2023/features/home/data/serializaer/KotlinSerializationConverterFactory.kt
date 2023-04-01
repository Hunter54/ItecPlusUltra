package com.example.timieu2023.features.home.data.serializaer

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter

private val json = Json {
    ignoreUnknownKeys = true
}

@OptIn(ExperimentalSerializationApi::class)
fun kotlinxConverterFactory(): Converter.Factory {

    val contentType = "application/json".toMediaType()
    return json.asConverterFactory(contentType)
}