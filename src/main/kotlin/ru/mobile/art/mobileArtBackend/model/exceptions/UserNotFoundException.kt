package ru.mobile.art.mobileArtBackend.model.exceptions

import ru.mobile.art.mobileArtBackend.model.userNotFoundMessage

class UserNotFoundException(
    override val message: String = userNotFoundMessage
): ItLeadersException(message)