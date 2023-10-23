package adventofcode.day10

import adventofcode.day10.model.Bracket
import adventofcode.day10.model.CorruptedLine
import adventofcode.day10.model.IncompletedLine

class BracketMatcher {

    fun getCorruptedLines(lines: List<String>): List<CorruptedLine> {
        return lines.mapNotNull(this::findCorruptedLine)
    }

    private fun findCorruptedLine(line: String): CorruptedLine? {
        val stack = ArrayDeque<Bracket>()
        line.forEachIndexed { index, symbol ->
            val bracket = Bracket.valueOf(symbol = symbol)
            if (bracket.isOpen(symbol = symbol)) {
                // Add to stack
                stack.addLast(bracket)
            } else {
                // Check from stack
                val lastOpened = stack.removeLast()
                if (bracket != lastOpened) {
                    return CorruptedLine(
                        line = line,
                        bracket = bracket,
                        index = index
                    )
                }
            }
        }
        return null
    }


    fun getIncompletedLines(lines: List<String>): List<IncompletedLine> {
        val corruptedLines = this.getCorruptedLines(lines)

        val allIncompletedLines = lines.filter { line -> corruptedLines.firstOrNull { it.line == line } == null }
        println("Number of incompleted lines is ${allIncompletedLines.size}")
        return allIncompletedLines.map(this::toIncompletedLine)
    }

    fun toIncompletedLine(line: String): IncompletedLine {
        val incompledBrackets = getIncompledBrackets(line)
        val bracketsToComplete = incompledBrackets.reversed()
        return IncompletedLine(
            line = line,
            bracketsToComplete = bracketsToComplete
        )
    }

    fun List<Bracket>.toOpenedString() = this.map(Bracket::open).joinToString(separator = "")
    fun List<Bracket>.toClosedString() = this.map(Bracket::close).joinToString(separator = "")

    private fun getIncompledBrackets(line: String): List<Bracket> {
        val stack = ArrayDeque<Bracket>()
        line.forEach { symbol ->
            val bracket = Bracket.valueOf(symbol = symbol)
            if (bracket.isOpen(symbol = symbol)) {
                // Add to stack
                stack.addLast(bracket)
            } else {
                // Check from stack
                stack.removeLast()
            }
        }
        return stack.toList()
    }


}