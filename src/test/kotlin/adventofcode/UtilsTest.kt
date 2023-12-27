package adventofcode

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class UtilsTest {
    @Test
    fun `group string by symbols with count`() {
        val countSymbols = countSymbols("AABBCATBACSGST")

        countSymbols.size shouldBe 6
        countSymbols['A'] shouldBe 4
        countSymbols['B'] shouldBe 3
        countSymbols['C'] shouldBe 2
        countSymbols['G'] shouldBe 1
        countSymbols['S'] shouldBe 2
        countSymbols['T'] shouldBe 2
    }
}
