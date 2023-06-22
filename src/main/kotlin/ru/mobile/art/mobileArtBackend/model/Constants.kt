package ru.mobile.art.mobileArtBackend.model

import java.util.regex.Pattern

val emailPattern = Pattern.compile("(^\\s+$)|([a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?)")
const val secondsInMinute = 60L
const val hoursInDay = 24L

const val signingKey = "educationisthesupersecretkeyexamplehere"
const val issuerValue = "art"
const val accessTokenLiveTime = secondsInMinute
const val refreshTokenLiveTime = hoursInDay * 30


const val invalidEmailMessage = "Wrong email format"
const val userAlreadyExistMessage = "User already exist"
const val userNotFoundMessage = "User not found"
const val testsNotFoundMessage = "Tests data for user not found"
const val testNotFoundMessage = "Test not found"
const val newsNotFoundMessage = "News not found"
const val wrongTokenMessage = "Wrong token format"
const val wrongEnumValueMessage = "Wrong enum value"
const val unauthorizedAccessMessage = "User unauthorized"

const val apiLogin = "apiLogin"
const val apiPassword = "apiPassword"

const val authorityUser = "authorityUser"
const val authorityService = "authorityService"
const val authorityClaimName = "authorityClaims"

const val memoryUserDetailsService = "memoryUserDetailsService"