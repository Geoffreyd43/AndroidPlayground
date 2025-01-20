package com.example.kotlinplayground

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val geoff = Person("Geoff", 26, null, null)
    val atiqah = Person("Atiqah", 28, "climb", geoff)

    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println(this)
    }

    override fun toString(): String {
        var profileString: String = "Name: $name\nAge: $age\n"

        profileString += addHobbyString(this)

        profileString += addReferrer(referrer)

        return profileString
    }

    private fun addReferrer(referrer: Person?): String {
        return if (referrer != null) {
            "Has a referrer named ${referrer.name}, who ${addHobbyString(referrer)}"
        } else {
            "Has no referrers..."
        }
    }

    private fun addHobbyString(person: Person): String {
        return if (person.hobby != null) {
            "Likes to ${person.hobby}. "
        } else {
            "Has no hobbies... "
        }
    }
}
