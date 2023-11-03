package adventofcode.day12

import adventofcode.readInput
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class PuzzleTest {
    private val smallInput = """
        start-A
        start-b
        A-c
        A-b
        b-d
        A-end
        b-end
    """.trimIndent().split("\n").map { it.trim() }

    private val largerInput = """
        dc-end
        HN-start
        start-kj
        dc-start
        dc-HN
        LN-dc
        HN-end
        kj-sa
        kj-HN
        kj-dc
    """.trimIndent().split("\n").map { it.trim() }

    private val evenLargerInput = """
        fs-end
        he-DX
        fs-he
        start-DX
        pj-DX
        end-zg
        zg-sl
        zg-pj
        pj-he
        RW-he
        fs-DX
        pj-RW
        zg-RW
        start-pj
        he-WI
        zg-he
        pj-fs
        start-RW
    """.trimIndent().split("\n").map { it.trim() }

    @Test
    fun `test part 1 small input`() {
        Puzzle.calculatePart1(input = smallInput) shouldBe 10
    }

    @Test
    fun `test part 1 larger input`() {
        Puzzle.calculatePart1(input = largerInput) shouldBe 19
    }

    @Test
    fun `test part 1 even larger input`() {
        Puzzle.calculatePart1(input = evenLargerInput) shouldBe 226
    }

    @Test
    fun `test part 1`() {
        Puzzle.calculatePart1(input = readInput("input_day12")) shouldBe 3_485
    }

    @Test
    fun `test part 2 small input`() {
        Puzzle.calculatePart2(input = smallInput) shouldBe 36
    }

    @Test
    fun `test part 2 larger input`() {
        Puzzle.calculatePart2(input = largerInput) shouldBe 103
    }

    @Test
    fun `test part 2 even larger input`() {
        Puzzle.calculatePart2(input = evenLargerInput) shouldBe 3_509
    }

//
//    @Test
//    fun `test part 2`() {
//        Puzzle.calculatePart2(input = readInput("input_day12")) shouldBe 0
//    }
}