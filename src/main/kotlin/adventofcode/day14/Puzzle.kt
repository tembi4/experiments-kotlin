package adventofcode.day14

import adventofcode.countSymbols

class Puzzle {

    companion object {
        fun calculatePart1(input: List<String>) = calculate(input = input, totalSteps = 10)
        fun calculatePart2(input: List<String>) = calculate(input = input, totalSteps = 40)

        private fun calculate(input: List<String>, totalSteps: Int): Int {
            val (initialPolymerTemplate, pairInsertions) = InputReader.read(input)

            val symbolsCount = countSymbols(initialPolymerTemplate).toMutableMap()

            val queue = initialPolymerTemplate.windowed(2).toMutableList()

            for (step in 1..totalSteps) {
                println("Current queue size is ${queue.size}")

                val newTasks = mutableListOf<String>()
                queue.forEach { pair ->
                    // Each insertion will increase the Count
                    val symbolToInsert = pairInsertions[pair]
                    symbolsCount.increase(key = symbolToInsert!!, increment = 1)

                    // Create 2 more tasks
                    newTasks.add("${pair[0]}$symbolToInsert")
                    newTasks.add("$symbolToInsert${pair[1]}")
                }
                queue.clear()
                queue.addAll(newTasks)
            }

            // Calculate the result
            val min = symbolsCount.minOf { it.value }
            val max = symbolsCount.maxOf { it.value }

            return max - min
        }

        private fun MutableMap<Char, Int>.increase(key: Char, increment: Int) {
            var currentCount = this.getOrDefault(key, 0)
            this[key] = currentCount + increment
        }
    }
}