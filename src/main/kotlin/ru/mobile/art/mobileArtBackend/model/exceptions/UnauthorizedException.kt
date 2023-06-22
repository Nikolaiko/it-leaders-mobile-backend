package ru.mobile.art.mobileArtBackend.model.exceptions

import ru.mobile.art.mobileArtBackend.model.unauthorizedAccessMessage
import ru.mobile.art.mobileArtBackend.model.userAlreadyExistMessage

class UnauthorizedException(
    override val message: String = unauthorizedAccessMessage
): ItLeadersException(message)
