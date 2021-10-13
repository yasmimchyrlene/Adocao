package com.ong.adocao.controller.handler.exception

class NotFoundException : RuntimeException{
    constructor (message: String): super(message)
}