package adventofcode.day11

import adventofcode.readInput
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PuzzleTest {
    private val smallInput = """
        5483143223
        2745854711
        5264556173
        6141336146
        6357385478
        4167524645
        2176841721
        6882881134
        4846848554
        5283751526
    """.trimIndent().split("\n").map { it.trim() }

    @Test
    fun `test part 1 small input`() {
        Puzzle.calculatePart1(input = smallInput) shouldBe 1656
    }

    @Test
    fun `test part 1`() {
        Puzzle.calculatePart1(input = readInput("input_day11")) shouldBe 1632
    }

    @Test
    fun `test part 2 small input`() {
        Puzzle.calculatePart2(input = smallInput) shouldBe 195
    }

    @Test
    fun `test part 2`() {
        Puzzle.calculatePart2(input = readInput("input_day11")) shouldBe 303
    }
}