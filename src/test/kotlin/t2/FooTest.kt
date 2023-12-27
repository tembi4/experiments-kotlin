package t2

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class FooTest {
    @Test
    fun `foo`() {

        val s = "32432:343:dfs:foo"


        val result = s.substringAfterLast(":")
        result shouldBe "foo"

    }
}