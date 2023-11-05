package adventofcode.day13

import adventofcode.readInput
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PuzzleTest {
    private val smallInput = """
        6,10
        0,14
        9,10
        0,3
        10,4
        4,11
        6,0
        6,12
        4,1
        0,13
        10,12
        3,4
        3,0
        8,4
        1,10
        2,14
        8,10
        9,0

        fold along y=7
        fold along x=5
    """.trimIndent().split("\n").map { it.trim() }

    @Test
    fun `test part 1 small input`() {
        Puzzle.calculatePart1(input = smallInput) shouldBe 17
    }

    @Test
    fun `test part 1`() {
        Puzzle.calculatePart1(input = readInput("input_day13")) shouldBe 735
    }

//    @Test
//    fun `test part 2`() {
//        Puzzle.calculatePart2(input = readInput("input_day13")) shouldBe 735
//    }
}