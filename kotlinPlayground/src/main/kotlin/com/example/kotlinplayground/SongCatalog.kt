package com.example.kotlinplayground

class SongCatalog(private val title: String,
                  private val artist: String,
                  private val yearPublished: Int,
                  private val playCount: Int) {

    public fun isPopular(): Boolean {
        return playCount > 1000
    }

    override fun toString(): String {
        return "$title, performed by $artist, was released in $yearPublished with play count $playCount."
    }
}

fun main() {
    val song1 = SongCatalog("Hail to the King", "Avenged Sevenfold", 2013, 500000)
    println(song1)
    println(song1.isPopular())

    val song2 = SongCatalog("Unholy Confessions", "Avenged Sevenfold", 2004, 500)
    println(song2)
    println(song2.isPopular())
}