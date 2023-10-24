package adventofcode.day10.model

import adventofcode.day10.model.Bracket.*

class PointsCalculator {
    fun calculateForCorruptedLines(corruptedLines: List<CorruptedLine>) =
        corruptedLines.map(CorruptedLine::bracket).sumOf(this::getPointsForCorruptedLine)

    private fun getPointsForCorruptedLine(bracket: Bracket) = when (bracket) {
        ROUND -> 3
        SQUARE -> 57
        CURLY -> 1197
        TRIANGLE -> 25137
    }

    fun calculateForIncompletedLines(incompletedLines: List<IncompletedLine>) =
        incompletedLines.map(IncompletedLine::bracketsToComplete).map(this::calculateTotalPoints)

    fun calculateTotalPoints(brackets: List<Bracket>) =
        brackets.map(this::getPointsForIncompletedLine).fold(0L) { acc, point -> acc * 5 + point }

    private fun getPointsForIncompletedLine(bracket: Bracket) = when (bracket) {
        ROUND -> 1
        SQUARE -> 2
        CURLY -> 3
        TRIANGLE -> 4
    }
}