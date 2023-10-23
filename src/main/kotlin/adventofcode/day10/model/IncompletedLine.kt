package adventofcode.day10.model

data class IncompletedLine(
    val line: String,
    val bracketsToComplete: List<Bracket>,
)
