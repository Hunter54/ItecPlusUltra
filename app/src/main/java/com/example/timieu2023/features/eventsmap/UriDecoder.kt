package com.example.timieu2023.features.eventsmap

import android.net.Uri
import javax.inject.Inject

class UriDecoder @Inject constructor() : StringDecoder {
    override fun decodeString(encodedString: String): String = Uri.decode(encodedString)
}
