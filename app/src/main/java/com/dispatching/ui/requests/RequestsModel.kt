package com.dispatching.ui.requests

import com.dispatching.domain.Request

class RequestsModel {
    val requests = mutableListOf<Request>()
    var selectedPage = 0
}