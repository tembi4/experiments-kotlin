package adventofcode.day11

import adventofcode.day11.model.Field

class Puzzle {
    companion object {

        private const val STEPS_COUNT = 100

        fun calculatePart1(input: List<String>): Int {
            val energyLevelOfEachOctopus: List<List<Short>> = input.map { line ->
                line.map { num -> num.toString().toShort() }
            }

            val field = Field(energyLevelOfEachOctopus = energyLevelOfEachOctopus)


            var totalNumberOfFlashes = 0

            for (step in 1..STEPS_COUNT) {
                val numberOfOctopusesFlashed = field.doStep()


                totalNumberOfFlashes += numberOfOctopusesFlashed
            }


            return totalNumberOfFlashes
        }

        fun calculatePart2(input: List<String>): Int {
            val energyLevelOfEachOctopus: List<List<Short>> = input.map { line ->
                line.map { num -> num.toString().toShort() }
            }

            val field = Field(energyLevelOfEachOctopus = energyLevelOfEachOctopus)

            var step = 0

            do {
                val numberOfOctopusesFlashed = field.doStep()
                step++
            } while (numberOfOctopusesFlashed != field.octopusCount)

            return step
        }

    }
}