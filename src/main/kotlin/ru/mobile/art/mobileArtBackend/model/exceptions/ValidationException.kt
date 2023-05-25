package ru.mobile.art.mobileArtBackend.model.exceptions

class ValidationException (
    override val message: String
): ItLeadersException(message)