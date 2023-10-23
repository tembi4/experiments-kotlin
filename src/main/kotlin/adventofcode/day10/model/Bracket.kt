package adventofcode.day10.model

enum class Bracket(
    val open: Char,
    val close: Char,
) {
    ROUND('(', ')'),
    SQUARE('[', ']'),
    CURLY('{', '}'),
    TRIANGLE('<', '>');

    fun isOpen(symbol: Char): Boolean = open == symbol

    companion object {
        fun valueOf(symbol: Char): Bracket {
            return entries.first { symbol in listOf(it.open, it.close) }
        }
    }


}