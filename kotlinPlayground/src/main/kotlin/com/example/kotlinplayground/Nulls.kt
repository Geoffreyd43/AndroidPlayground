package com.example.kotlinplayground

fun nulls() {
    // By default, normal variables cannot be assigned to null
    // ex:
    // var name: String = "Geoffrey"
    // name = null // error: Null can not be a value of a non-null type String

    // Must declare variable as nullable (using ? after type)
    var name: String? = "Geoffrey"

    println(name?.length)
    println(name!!.length)

    name = null
    println(name?.length)
//    println(name!!.length) // doesn't even compile
}