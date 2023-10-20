package adventofcode.day09

import adventofcode.readInput
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlin.test.Test

class PuzzleTestPart2 {

    private val smallInput = """
        2199943210
        3987894921
        9856789892
        8767896789
        9899965678
    """.trimIndent().split("\n").map { it.trim() }

    @Test
    fun `test basin for small input`() {
        Puzzle.calculateResultForBasin(smallInput) shouldBe 1_134
    }

    @Test
    fun `test basin for input`() {
        val input = readInput("input_day09")
        val result = Puzzle.calculateResultForBasin(input)
        result shouldNotBe 328509
        result shouldNotBe 314364
        result shouldBe 0
    }
}