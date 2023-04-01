package com.example

import androidx.annotation.StringRes

sealed class ApiState<T> {
    data class Success<T>(val data: T) : ApiState<T>()
    data class Failed<T>(@StringRes val message: Int) : ApiState<T>()
}
