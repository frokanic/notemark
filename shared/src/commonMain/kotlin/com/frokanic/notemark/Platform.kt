package com.frokanic.notemark

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform