package com.ong.adocao.controller.handler

import com.ong.adocao.controller.handler.exception.BadRequestException
import com.ong.adocao.controller.handler.exception.GlobalError
import com.ong.adocao.controller.handler.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class AdocaoHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(BadRequestException::class)
    fun badRequest(
        servletRequest: HttpServletRequest,
        servletResponse: HttpServletResponse,
        exception: Exception
    ): ResponseEntity<GlobalError> {
        val globalError = GlobalError("Bad Request", 400, exception.message!!)
        return ResponseEntity(globalError, HttpStatus.BAD_REQUEST)

    }

    @ExceptionHandler(NotFoundException::class)
    fun notFound(
        servletRequest: HttpServletRequest,
        servletResponse: HttpServletResponse,
        exception: Exception
    ): ResponseEntity<GlobalError> {
        val globalError = GlobalError("Page Not Found", 404, exception.message!!)
        return ResponseEntity(globalError, HttpStatus.NOT_FOUND)
    }
}