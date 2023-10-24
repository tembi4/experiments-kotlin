package adventofcode.day11.model

// Convert row, col to Int
class Octopus(initialEnergy: Short, val row: Short, val col: Short) {

    private var currentEnergy = initialEnergy

    fun gainEnergy() {
        currentEnergy++
    }

    fun flash() {
        currentEnergy = 0
    }

    fun isFlush() = currentEnergy > 9
    fun isNotFlashed() = currentEnergy.toInt() != 0
}