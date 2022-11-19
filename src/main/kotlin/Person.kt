package html

data class Person(
    var name: String? = null,
    var age: Int? = null,
    val children: MutableList<Person> = ArrayList()
) {
    fun child(init: Person.() -> Unit) = Person().also {
        it.init()
        children.add(it)
    }
}

fun person(init: Person.() -> Unit) = Person().apply { init() }

fun main(args: Array<String>) {
    val p = person {
        name = "Mommy"
        age = 33
        child {
            name = "Gugu"
            age = 2
        }
        child {
            name = "Gaga"
            age = 3
        }
    }
    println(p)
}