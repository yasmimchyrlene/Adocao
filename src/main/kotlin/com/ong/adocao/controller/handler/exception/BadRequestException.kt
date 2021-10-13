package com.ong.adocao.controller.handler.exception

class BadRequestException : RuntimeException{
    constructor (message: String): super(message)
}