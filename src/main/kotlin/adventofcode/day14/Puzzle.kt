package adventofcode.day14

import adventofcode.countSymbolsAsLongMutable

class Puzzle {

    companion object {
        fun calculatePart1(input: List<String>) = calculate(input = input, totalSteps = 10)
        fun calculatePart2(input: List<String>) = calculate(input = input, totalSteps = 40)

        private fun calculate(input: List<String>, totalSteps: Int): Long {
            val (initialPolymerTemplate, pairInsertions) = InputReader.read(input)

            val symbolsCount: MutableMap<Char, Long> = countSymbolsAsLongMutable(initialPolymerTemplate)
            val pairs = initialPolymerTemplate.windowed(2).groupingBy { it }.eachCount().map {
                it.key to it.value.toLong()
            }.toMap().toMutableMap()

            for (step in 1..totalSteps) {
                val newPairs = mutableMapOf<String, Long>()
                pairs.forEach { pairEntry ->
                    val (pair, numberOccurrence) = pairEntry

                    // Each insertion will increase the Count
                    val symbolToInsert =
                        pairInsertions[pair] ?: throw IllegalAccessException("$pair is not found in the vocabulary")
                    symbolsCount.increase(key = symbolToInsert, increment = numberOccurrence)

                    // Create 2 more tasks
                    val left = "${pair[0]}$symbolToInsert"
                    val right = "$symbolToInsert${pair[1]}"

                    newPairs[left] = newPairs.getOrDefault(left, 0) + numberOccurrence
                    newPairs[right] = newPairs.getOrDefault(right, 0) + numberOccurrence
                }

                pairs.clear()
                pairs.putAll(newPairs)
            }

            return symbolsCount.betweenMinMax()
        }

        private fun MutableMap<Char, Long>.increase(key: Char, increment: Long) {
            this[key] = getOrDefault(key, 0) + increment
        }

        private fun MutableMap<Char, Long>.betweenMinMax() = maxOf { it.value } - minOf { it.value }
    }
}