package com.example.venten.ui

import com.example.venten.model.ventenModel

class NetworkExtra {
    data class NetworkState(var loading: Boolean, var response: MutableList<ventenModel>?, var error: Throwable?)

}