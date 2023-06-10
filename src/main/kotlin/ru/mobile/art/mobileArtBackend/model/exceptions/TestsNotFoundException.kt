package ru.mobile.art.mobileArtBackend.model.exceptions

import ru.mobile.art.mobileArtBackend.model.testsNotFoundMessage
import ru.mobile.art.mobileArtBackend.model.userNotFoundMessage

class TestsNotFoundException(
    override val message: String = testsNotFoundMessage
): ItLeadersException(message)