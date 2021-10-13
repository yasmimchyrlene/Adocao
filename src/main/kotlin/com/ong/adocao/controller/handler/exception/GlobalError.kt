package com.ong.adocao.controller.handler.exception

data class GlobalError(
    var status: String = "",
    var code: Int = 0,
    var message: String = ""
)