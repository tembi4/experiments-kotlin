package adventofcode.day09

class BasinCalculator(
    private val field: Field,
    private val isLogging: Boolean = false,
) {

    fun totalLocationsCount(): Int {

        val allBasins = mutableSetOf<Basin>()

        for (row in 0..<field.size){
            for (col in 0..<field.colSize(row)) {
                val currentPoint = Point(row, col)
                if (field.isValid(currentPoint) && isLowestFromAdjacent(point = currentPoint)) {
                    // Create a new basin
                    val basin = Basin(currentPoint)

                    if (isLogging) {
                        println("Searching for all points for $basin")
                    }
                    // Now, we need to find all points of the basin
                    findAllPoints(basin, currentPoint)

                    allBasins.add(basin)

                    if (isLogging) {
                        println("Found that for $basin has size ${basin.size}")
//                        printBasin(basin)
                        println("--------------------------------------------------")
                    }
                }
            }
        }

        // The result is 3 largest basins' sizes multiplied between each other
        val largestBasins = allBasins.sortedByDescending(Basin::size)
        if (isLogging) {
            largestBasins.forEach {
                println("Largest Basins $it with size ${it.size}")
            }
        }

        return largestBasins
            .take(3)
            .fold(1) { acc, basin -> acc * basin.size }
    }

    private fun findAllPoints(basin: Basin, point: Point) {
        Side.values().forEach { side ->
            val pointToCheck = field.pointToCheck(side = side, point = point)
            pointToCheck?.let {
                if (basin.notContains(point = pointToCheck)
                    && isLowestFromAdjacent(point = pointToCheck, basin = basin)
                ) {
                    basin.addPoint(point = pointToCheck)
                    // Call the next point as recursion
                    findAllPoints(basin = basin, point = pointToCheck)
                }
            }
        }
    }

    private fun isLowestFromAdjacent(point: Point, basin: Basin? = null): Boolean {
        Side.values().forEach { side ->
            val pointToCheck = field.pointToCheck(side = side, point = point)
            pointToCheck?.let {
                if ((basin == null || basin.notContains(point = pointToCheck))
                    && field[pointToCheck] <= field[point]
                ) {
                    return false
                }
            }
        }
        return true
    }
}