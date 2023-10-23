package adventofcode.day10

import adventofcode.day10.model.Bracket
import adventofcode.day10.model.CorruptedLine
import adventofcode.day10.model.IncompletedLine

class Puzzle {

    companion object {
        val bracketMatcher = BracketMatcher()
        fun calculatePart1(input: List<String>): Int {

            val corruptedLines = bracketMatcher.getCorruptedLines(input)
            println("Number of corrupted lines is ${corruptedLines.size}")
            return corruptedLines.map(CorruptedLine::bracket).sumOf(this::getPointsForCorruptedLine)
        }

        private fun getPointsForCorruptedLine(bracket: Bracket): Int {
            return when (bracket) {
                Bracket.ROUND -> 3
                Bracket.SQUARE -> 57
                Bracket.CURLY -> 1197
                Bracket.TRIANGLE -> 25137
            }
        }

        fun calculatePart2(input: List<String>): Long {

            val incompletedLines = bracketMatcher.getIncompletedLines(lines = input)
            if (incompletedLines.size.mod(2) == 0) {
                throw IllegalStateException("The size of incompleted lines must be odd")
            }

            val totalPoints = incompletedLines.map(this::calculatePoints)
                .sorted()


            val middleIndex = totalPoints.size / 2
            return totalPoints[middleIndex]
        }

        fun calculatePoints(incompletedLine: IncompletedLine): Long {
            val brackets = incompletedLine.bracketsToComplete
            // Check fold as solution
            var result = 0L
            brackets.forEach { bracket ->
                result *= 5
                result += getPointsForIncompletedLine(bracket)
            }
            return result
        }


        private fun getPointsForIncompletedLine(bracket: Bracket): Int {
            return when (bracket) {
                Bracket.ROUND -> 1
                Bracket.SQUARE -> 2
                Bracket.CURLY -> 3
                Bracket.TRIANGLE -> 4
            }
        }
    }
}