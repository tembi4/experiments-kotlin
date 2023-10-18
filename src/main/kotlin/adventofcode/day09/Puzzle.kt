package adventofcode.day09

class Puzzle {

    companion object {
        fun calculateResult(input: List<String>): Int {

            var numbers = input.map { it.split("").filter { num -> num.isNotEmpty() }.map { num -> num.toInt() } }

            var result = 0

            for (row in numbers.indices) {
                for (col in numbers[row].indices) {
                    val num = numbers[row][col]
                    if (isLowestFromAdjacent(num, numbers, row, col)) {
                        println("Lowest at ($row,$col) with value $num")
                        result += (num + 1)
                    }
                }
            }
            return result
        }

        private fun isLowestFromAdjacent(num: Int, numbers: List<List<Int>>, row: Int, col: Int): Boolean {

            if (row > 0) {
                // Check top
                val top = numbers[row - 1][col]
                if (top <= num) return false
            }
            if (row < numbers.size - 1) {
                // Check bottom
                val bottom = numbers[row + 1][col]
                if (bottom <= num) return false
            }
            if (col > 0) {
                // Check left
                val left = numbers[row][col - 1]
                if (left <= num) return false
            }
            if (col < numbers[row].size - 1) {
                // Check right
                val right = numbers[row][col + 1]
                if (right <= num) return false
            }
            return true
        }


        // Part two
        fun calculateResultForBasin(input: List<String>): Int {

            var numbers = input
                .map {
                    it.split("")
                        .filter(String::isNotEmpty)
                        .map(String::toInt)
                }

            val basinCalculator = BasinCalculator(numbers)

            return basinCalculator.totalLocationsCount()
        }
    }
}