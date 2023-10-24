package adventofcode.day10

import adventofcode.day10.model.Bracket
import adventofcode.readInput
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class PuzzleTest {

    private val smallInput = """
    [({(<(())[]>[[{[]{<()<>>
[(()[<>])]({[<{<<[]>>(
{([(<{}[<>[]}>{[]{[(<()>
(((({<>}<{<{<>}{[]{[]{}
[[<[([]))<([[{}[[()]]]
[{[{({}]{}}([{[{{{}}([]
{<[[]]>}<{[{[{[]{()[[[]
[<(<(<(<{}))><([]([]()
<{([([[(<>()){}]>(<<{{
<{([{{}}[<[[[<>{}]]]>[]]
    """.trimIndent().split("\n").map { it.trim() }

    @Test
    fun `test part 1 small input`() {
        Puzzle.calculatePart1(input = smallInput) shouldBe 26_397
    }

    @Test
    fun `test part 1`() {
        Puzzle.calculatePart1(input = readInput("input_day10")) shouldBe 413_733
    }

    @Test
    fun `test part 2 small input`() {
        Puzzle.calculatePart2(input = smallInput) shouldBe 288_957
    }

    @Test
    fun `test part 2`() {
        Puzzle.calculatePart2(input = readInput("input_day10")) shouldBe 3_354_640_192
    }
}