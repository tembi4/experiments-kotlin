package adventofcode.day11.model

class Field(energyLevelOfEachOctopus: List<List<Short>>) {

    var octopusCount = 0

    private val octopuses: List<List<Octopus>> = energyLevelOfEachOctopus.mapIndexed { row, listOfEnergy ->
        listOfEnergy.mapIndexed { col, energy ->
            octopusCount++
            Octopus(
                initialEnergy = energy,
                row = row.toShort(),
                col = col.toShort()
            )
        }
    }



    fun doStep(): Int {
        // For each step, energy increases by 1
        octopuses.forEach { row ->
            row.forEach { octopus ->
                octopus.gainEnergy()
            }
        }

        // All octopuses with energy level greater than 9 flashes
        // This increases energy of adjacent by 1, including diagonal
        // if energy > 9 - it also flashes, and so on
        // An octopus can only flash at most once per step.

        // any octopus that flashed during this step has its energy level set to 0
        var totalFlashesAtStep = 0
        do {
            // Get all octopuses which flushes
            var octopusesToFlush: MutableList<Octopus> = getOctopusesWhichFlashes()
            totalFlashesAtStep += octopusesToFlush.size

            octopusesToFlush.forEach { octopus ->
                octopus.flash()
                energiseAllAdjacent(row = octopus.row, col = octopus.col)
            }

        } while (octopusesToFlush.isNotEmpty())

        return totalFlashesAtStep
    }

    private fun getOctopusesWhichFlashes(): MutableList<Octopus> =
        octopuses.flatten().filter(Octopus::isFlush).toMutableList()

    private fun energiseAllAdjacent(row: Short, col: Short) {
        /*
           123
           4X5
           678
        */
        // 1
        if (row > 0 && col > 0) {
            val octopus = octopuses[row - 1][col - 1]
            if (octopus.isNotFlashed()) {
                octopus.gainEnergy()
            }
        }

        // 2
        if (row > 0) {
            val octopus = octopuses[row - 1][col.toInt()]
            if (octopus.isNotFlashed()) {
                octopus.gainEnergy()
            }
        }

        // 3
        if (row > 0 && col < octopuses[row.toInt()].size - 1) {
            val octopus = octopuses[row - 1][col + 1]
            if (octopus.isNotFlashed()) {
                octopus.gainEnergy()
            }
        }

        // 4
        if (col > 0) {
            val octopus = octopuses[row.toInt()][col - 1]
            if (octopus.isNotFlashed()) {
                octopus.gainEnergy()
            }
        }

        // 5
        if (col < octopuses[row.toInt()].size - 1) {
            val octopus = octopuses[row.toInt()][col + 1]
            if (octopus.isNotFlashed()) {
                octopus.gainEnergy()
            }
        }

        // 6
        if (row < octopuses.size - 1 && col > 0) {
            val octopus = octopuses[row + 1][col - 1]
            if (octopus.isNotFlashed()) {
                octopus.gainEnergy()
            }
        }

        // 7
        if (row < octopuses.size - 1) {
            val octopus = octopuses[row + 1][col.toInt()]
            if (octopus.isNotFlashed()) {
                octopus.gainEnergy()
            }
        }

        // 8
        if (row < octopuses.size - 1 && col < octopuses[row.toInt()].size - 1) {
            val octopus = octopuses[row + 1][col + 1]
            if (octopus.isNotFlashed()) {
                octopus.gainEnergy()
            }
        }
    }
}