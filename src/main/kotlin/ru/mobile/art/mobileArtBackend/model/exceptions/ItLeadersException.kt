package ru.mobile.art.mobileArtBackend.model.exceptions

open class ItLeadersException(
    message: String? = null,
    cause: Throwable? = null
): RuntimeException(message, cause)