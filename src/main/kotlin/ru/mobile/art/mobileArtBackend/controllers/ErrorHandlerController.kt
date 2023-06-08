package ru.mobile.art.mobileArtBackend.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.mobile.art.mobileArtBackend.dto.ErrorMessageDTO
import ru.mobile.art.mobileArtBackend.model.exceptions.NewsNotFoundException
import ru.mobile.art.mobileArtBackend.model.exceptions.UserAlreadyExistException
import ru.mobile.art.mobileArtBackend.model.exceptions.UserNotFoundException
import ru.mobile.art.mobileArtBackend.model.exceptions.ValidationException

@RestControllerAdvice
class ErrorHandlerController {

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
}