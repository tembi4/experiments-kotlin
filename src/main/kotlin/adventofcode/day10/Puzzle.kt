package adventofcode.day10

import adventofcode.day10.model.PointsCalculator

class Puzzle {

    companion object {
        private val bracketMatcher = BracketMatcher()
        private val pointsCalculator = PointsCalculator()

        fun calculatePart1(input: List<String>): Int {
            val corruptedLines = bracketMatcher.getCorruptedLines(input)
            println("Number of corrupted lines is ${corruptedLines.size}")
            return pointsCalculator.calculateForCorruptedLines(corruptedLines = corruptedLines)
        }

        fun calculatePart2(input: List<String>): Long {
            val incompletedLines = bracketMatcher.getIncompletedLines(lines = input)
            if (incompletedLines.size.mod(2) == 0) {
                throw IllegalStateException("The size of incompleted lines must be odd")
            }
            val totalPoints = pointsCalculator.calculateForIncompletedLines(incompletedLines = incompletedLines)
                .sorted()
            val middleIndex = totalPoints.size / 2
            return totalPoints[middleIndex]
        }
    }
}