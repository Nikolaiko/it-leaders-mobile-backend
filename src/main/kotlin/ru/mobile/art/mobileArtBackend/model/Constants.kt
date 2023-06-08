package ru.mobile.art.mobileArtBackend.model

import java.util.regex.Pattern

val emailPattern = Pattern.compile("(^\\s+$)|([a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)")

const val signingKey = "educationisthesupersecretkeyexamplehere"
const val issuerValue = "art"


const val invalidEmailMessage = "Wrong email format"
const val userAlreadyExistMessage = "User already exist"
const val userNotFoundMessage = "User not found"
const val newsNotFoundMessage = "News not found"
const val wrongTokenMessage = "Wrong token format"
const val wrongEnumValueMessage = "Wrong enum value"