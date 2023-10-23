package adventofcode.day10

import adventofcode.day10.model.Bracket
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class BracketMatcherTest {

    fun List<Bracket>.toClosedString() = this.map(Bracket::close).joinToString(separator = "")

    @Test
    fun `test incompleted lines from example 1`() {
        val bracketMatcher = BracketMatcher()
        val result = bracketMatcher.toIncompletedLine(line =
        """[({(<(())[]>[[{[]{<()<>>""")
        result.bracketsToComplete.toClosedString() shouldBe """}}]])})]"""

        val points = Puzzle.calculatePoints(result)
        points shouldBe 288_957
    }
    @Test
    fun `test incompleted lines from example 2`() {
        val bracketMatcher = BracketMatcher()
        val result = bracketMatcher.toIncompletedLine(line =
        """[(()[<>])]({[<{<<[]>>(""")
        result.bracketsToComplete.toClosedString() shouldBe """)}>]})"""

        val points = Puzzle.calculatePoints(result)
        points shouldBe 5_566
    }
    @Test
    fun `test incompleted lines from example 3`() {
        val bracketMatcher = BracketMatcher()
        val result = bracketMatcher.toIncompletedLine(line =
        """(((({<>}<{<{<>}{[]{[]{}""")
        result.bracketsToComplete.toClosedString() shouldBe """}}>}>))))"""

        val points = Puzzle.calculatePoints(result)
        points shouldBe 1_480_781
    }
    @Test
    fun `test incompleted lines from example 4`() {
        val bracketMatcher = BracketMatcher()
        val result = bracketMatcher.toIncompletedLine(line =
        """{<[[]]>}<{[{[{[]{()[[[]""")
        result.bracketsToComplete.toClosedString() shouldBe """]]}}]}]}>"""

        val points = Puzzle.calculatePoints(result)
        points shouldBe 995_444
    }
    @Test
    fun `test incompleted lines from example 5`() {
        val bracketMatcher = BracketMatcher()
        val result = bracketMatcher.toIncompletedLine(line =
        """<{([{{}}[<[[[<>{}]]]>[]]""")
        result.bracketsToComplete.toClosedString() shouldBe """])}>"""

        val points = Puzzle.calculatePoints(result)
        points shouldBe 294
    }

    @Test
    fun `test incompleted line from input line 1`() {
        val bracketMatcher = BracketMatcher()
        val result = bracketMatcher.toIncompletedLine(line =
        """<([[<<(([{<<{<[]><(){}>}<[{}][{}{}]>>{({{}()})[[[]()][()()]]}>}][<([[[{}{}][[]]]]<<<{}<>>{[][]""")
        result.bracketsToComplete.toClosedString() shouldBe """}>>)>]))>>]])>"""

        val points = Puzzle.calculatePoints(result)
        points shouldBe 557_485_513
    }


}