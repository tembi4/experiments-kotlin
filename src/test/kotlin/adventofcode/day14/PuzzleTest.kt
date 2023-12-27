package adventofcode.day14

import adventofcode.readInput
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PuzzleTest {

    private val smallInput = """
        NNCB

        CH -> B
        HH -> N
        CB -> H
        NH -> C
        HB -> C
        HC -> B
        HN -> C
        NN -> C
        BH -> H
        NC -> B
        NB -> B
        BN -> B
        BB -> N
        BC -> B
        CC -> N
        CN -> C
    """.trimIndent().split("\n").map { it.trim() }

    @Test
    fun `test part 1 small input`() {
        Puzzle.calculatePart1(input = smallInput) shouldBe 1_588
    }

    @Test
    fun `test part 1`() {
        Puzzle.calculatePart1(input = readInput("input_day14")) shouldBe 2_170
    }

    @Test
    fun `test part 2 small input`() {
        Puzzle.calculatePart2(input = smallInput) shouldBe 2188189693529
    }

    @Test
    fun `test part 2`() {
        Puzzle.calculatePart2(input = readInput("input_day14")) shouldBe 2422444761283
    }

}