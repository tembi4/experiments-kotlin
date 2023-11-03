package t2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class MapListWithSplitTest {

    @Test
    fun `test to map objects into 2 lists by ids and names`() {

        val testData = listOf(
            Fare("1", "One", "foo"),
            Fare("2", "Two", "baz"),
            Fare("1", "Three"),
            Fare("2", "One", "bar"),
            Fare("3", "Three", ),
        )

        val expectedIds = listOf("1", "2", "3")
        val expectedNames = listOf("One", "Two", "Three")

        val (idsList, namesList) = testData.map { it.id to it.name }.unzip()

        val ids = idsList.toSet().toList()
        val names = namesList.toSet().toList()

        ids shouldBe expectedIds
        names shouldBe expectedNames
    }

}