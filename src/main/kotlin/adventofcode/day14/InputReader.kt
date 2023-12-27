package adventofcode.day14

class InputReader {
    companion object {

        private val insertionRegExp = """([A-Z]{2}) -> ([A-Z])""".toRegex()

        fun read(input: List<String>): Pair<String, Map<String, Char>> {

            val polymerTemplate = input[0]

            val pairInsertions = input
                .filter { insertionRegExp.matches(it) }.associate {
                    val (pair, result) = insertionRegExp.find(it)!!.destructured
                    pair to result[0]
                }

            return Pair(polymerTemplate, pairInsertions)
        }
    }
}