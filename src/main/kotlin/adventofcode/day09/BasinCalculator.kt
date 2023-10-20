package adventofcode.day09

class BasinCalculator(
    private val field: Field,
    private val isLogging: Boolean = false,
) {

    fun totalLocationsCount(): Int {

        val allBasins = mutableSetOf<Basin>()

        field.values.forEachIndexed { row, numbersInRow ->
            numbersInRow.forEachIndexed { col, _ ->
                val currentPoint = Point(row, col)
                if (isLowestFromAdjacent(currentPoint)) {
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
        // Check Top
        if (field.hasOnSide(side = Sides.TOP, point = point)) {
            val pointToCheck = point.top()
            if (!basin.contains(pointToCheck) && isPointPartOfBasin(pointToCheck, basin)) {
                basin.addPoint(pointToCheck)
                findAllPoints(basin = basin, point = pointToCheck)
            }
        }
        // Check Bottom
        if (field.hasOnSide(side = Sides.BOTTOM, point = point)) {
            val pointToCheck = point.bottom()
            if (!basin.contains(pointToCheck) && isPointPartOfBasin(pointToCheck, basin)) {
                basin.addPoint(pointToCheck)
                findAllPoints(basin = basin, point = pointToCheck)
            }
        }
        // Check Left
        if (field.hasOnSide(side = Sides.LEFT, point = point)) {
            val pointToCheck = point.left()
            if (!basin.contains(pointToCheck) && isPointPartOfBasin(pointToCheck, basin)) {
                basin.addPoint(pointToCheck)
                findAllPoints(basin = basin, point = pointToCheck)
            }
        }
        // Check Right
        if (field.hasOnSide(side = Sides.RIGHT, point = point)) {
            val pointToCheck = point.right()
            if (!basin.contains(pointToCheck) && isPointPartOfBasin(pointToCheck, basin)) {
                basin.addPoint(pointToCheck)
                findAllPoints(basin = basin, point = pointToCheck)
            }
        }
    }

    private fun isPointPartOfBasin(point: Point, basin: Basin): Boolean {
        val pointValue = field[point]

        // Check if the point is not corner and 9
        if (pointValue == 9) {
            return false
        }

        // Check Top
        if (field.hasOnSide(side = Sides.TOP, point = point)) {
            val pointToCheck = point.top()
            if (!basin.contains(pointToCheck) && field[pointToCheck] <= pointValue) return false
        }
        // Check Bottom
        if (field.hasOnSide(side = Sides.BOTTOM, point = point)) {
            val pointToCheck = point.bottom()
            if (!basin.contains(pointToCheck) && field[pointToCheck] <= pointValue) return false
        }
        // Check Left
        if (field.hasOnSide(side = Sides.LEFT, point = point)) {
            val pointToCheck = point.left()
            if (!basin.contains(pointToCheck) && field[pointToCheck] <= pointValue) return false
        }
        // Check Right
        if (field.hasOnSide(side = Sides.RIGHT, point = point)) {
            val pointToCheck = point.right()
            if (!basin.contains(pointToCheck) && field[pointToCheck] <= pointValue) return false
        }

        return true
    }

    // The method can be merged with isPointPartOfBasin if to handle empty basin
    private fun isLowestFromAdjacent(point: Point): Boolean {

        val num = field[point]

        if (num == 9) {
            return false
        }

        if (field.hasTop(point)) {
            // Check top
            val top = field[point.top()]
            if (top <= num) return false
        }
        if (field.hasBottom(point)) {
            // Check bottom
            val bottom = field[point.bottom()]
            if (bottom <= num) return false
        }
        if (field.hasLeft(point)) {
            // Check left
            val left = field[point.left()]
            if (left <= num) return false
        }
        if (field.hasRight(point)) {
            // Check right
            val right = field[point.right()]
            if (right <= num) return false
        }
        return true
    }

}