package ru.mobile.art.mobileArtBackend.model.exceptions

import ru.mobile.art.mobileArtBackend.model.userAlreadyExistMessage

class UserAlreadyExistException(
    override val message: String = userAlreadyExistMessage
): ItLeadersException(message)