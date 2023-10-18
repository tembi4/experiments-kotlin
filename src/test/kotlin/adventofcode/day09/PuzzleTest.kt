package adventofcode.day09

import adventofcode.readInput
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class Puzzle17Test {

    private val smallInput = """
        2199943210
        3987894921
        9856789892
        8767896789
        9899965678
    """.trimIndent().split("\n").map { it.trim() }

    @Test
    fun `test for small input`() {
        Puzzle.calculateResult(smallInput) shouldBe 15
    }

    @Test
    fun `test for input`() {
        val input = readInput("input_day09")
        Puzzle.calculateResult(input) shouldBe 562
    }

    @Test
    fun `test basin for small input`() {
        Puzzle.calculateResultForBasin(smallInput) shouldBe 1_134
    }
}