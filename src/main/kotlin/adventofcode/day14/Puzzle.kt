package adventofcode.day14

import adventofcode.countSymbols
import java.util.*

class Puzzle {

    companion object {
        fun calculatePart1(input: List<String>) = calculate(input = input, totalSteps = 10)
        fun calculatePart2(input: List<String>) = calculate(input = input, totalSteps = 40)

        private fun calculate(input: List<String>, totalSteps: Int): Int {
            val (initialPolymerTemplate, pairInsertions) = InputReader.read(input)

            val symbolsCount = countSymbols(initialPolymerTemplate).toMutableMap()

            val tasksQueue = initialPolymerTemplate.windowed(2).map {
                Task(it, totalSteps)
            }.toMutableList()

            while (tasksQueue.isNotEmpty()) {

                println("Current queue size is ${tasksQueue.size}")
                val newTasks = mutableListOf<Task>()

                tasksQueue.forEach {task ->
                    val (pair, stepsRemain) = task
                    // Each insertion will increase the Count
                    if (stepsRemain > 0) {
                        val symbolToInsert = pairInsertions[pair]
                        var currentCount = symbolsCount.getOrDefault(symbolToInsert!!, 0)
                        symbolsCount[symbolToInsert] = currentCount + 1

                        // Create 2 more tasks
                        newTasks.add(Task("" + pair[0] + symbolToInsert, stepsRemain - 1))
                        newTasks.add(Task("" + symbolToInsert + pair[1], stepsRemain - 1))
                    }
                }
                tasksQueue.clear()
                tasksQueue.addAll(newTasks)
            }

            // Calculate the result
            val min = symbolsCount.minOf { it.value }
            val max = symbolsCount.maxOf { it.value }

            return max - min
        }
    }
}

data class Task(val pair: String, val stepsRemain: Int)