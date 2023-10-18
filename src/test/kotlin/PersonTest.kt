import kotlin.properties.Delegates
import kotlin.test.Test

class PersonTest {
    @Test
    fun `test person class`() {
        println("------------------------------------------------------------------")
        val johnDoe = Person("John Doe", 25, "Prague")
        println(johnDoe)
        johnDoe.moveTo("Brno")
        johnDoe.increaseAge()
        println(johnDoe)
        println("------------------------------------------------------------------")
        val janeSmith = Person(name = "Jane Smith", age = 33, city = "Melnik")
        println(janeSmith)
        janeSmith.let {person ->
            person.moveTo("Karlovy Vary")
            person.increaseAge(2)
        }
        println(janeSmith)
        println("------------------------------------------------------------------")
    }
}

class Person(
    private val name: String,
    age: Int,
    city: String
) {

    private var age: Int by Delegates.observable(age) { property, oldValue, newValue ->
        println("$name's age's been changes from $oldValue to $newValue")
    }
    private var city: String = city

    override fun toString(): String = "$name $age years old, living in $city"

    fun moveTo(newCity: String) {
        city = newCity
    }

    fun increaseAge(delta: Int = 1) {
        age += delta
    }
}
