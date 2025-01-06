package com.example.kotlinplayground

fun trafficLight(color: String) {
    when (color) {
        "red" -> println("STOP!")
        "yellow" -> println("Slow down there, partner!")
        "green" -> println("Full speed ahead :)")
        else -> println("I don't recognize $color, try again.") // default case. If this is missing, invalid input does nothing and continues executing
    }
}