package ru.mobile.art.mobileArtBackend.model.exceptions

import ru.mobile.art.mobileArtBackend.model.newsNotFoundMessage

class NewsNotFoundException(
    override val message: String = newsNotFoundMessage
): ItLeadersException(message)