package ru.mobile.art.mobileArtBackend.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.mobile.art.mobileArtBackend.dto.ErrorMessageDTO
import ru.mobile.art.mobileArtBackend.model.exceptions.*

@RestControllerAdvice
class ErrorHandlerController {

    @ExceptionHandler
    fun unauthorizedErrorHandler(exception: UnauthorizedException): ResponseEntity<ErrorMessageDTO> {
        return ResponseEntity(
            ErrorMessageDTO(exception.message),
            HttpStatus.UNAUTHORIZED
        )
    }

    @ExceptionHandler
    fun userAlreadyExistHandler(exception: UserAlreadyExistException): ResponseEntity<ErrorMessageDTO> {
        return ResponseEntity(
            ErrorMessageDTO(exception.message),
            HttpStatus.CONFLICT
        )
    }

    @ExceptionHandler
    fun userNotFoundHandler(exception: UserNotFoundException): ResponseEntity<ErrorMessageDTO> {
        return ResponseEntity(
            ErrorMessageDTO(exception.message),
            HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler
    fun newsNotFoundHandler(exception: NewsNotFoundException): ResponseEntity<ErrorMessageDTO> {
        return ResponseEntity(
            ErrorMessageDTO(exception.message),
            HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler
    fun validationExceptionHandler(exception: ValidationException): ResponseEntity<ErrorMessageDTO> {
        return ResponseEntity(
            ErrorMessageDTO(exception.message),
            HttpStatus.UNPROCESSABLE_ENTITY
        )
    }

    @ExceptionHandler
    fun testsExceptionHandler(exception: TestsNotFoundException): ResponseEntity<ErrorMessageDTO> {
        return ResponseEntity(
            ErrorMessageDTO(exception.message),
            HttpStatus.NOT_FOUND
        )
    }
}