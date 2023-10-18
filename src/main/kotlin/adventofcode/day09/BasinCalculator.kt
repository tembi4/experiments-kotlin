package adventofcode.day09

class BasinCalculator(private val field: List<List<Int>>) {

    /*
    *
    * // Everything after this is in red
val red = "\u001b[31m"

// Resets previous color codes
val reset = "\u001b[0m"

println(red + "Hello World!" + reset)
    *
    *
    * */


    fun totalLocationsCount(): Int {

        val allBasins = mutableSetOf<Basin>()

        field.forEachIndexed { row, numbersInRow ->
            numbersInRow.forEachIndexed { col, num ->
                val currentPoint = Point(row, col)
                if (isLowestFromAdjacent(num, currentPoint)) {
                    // Create a new basin
                    val basin = Basin(currentPoint)
//                    println("Searching for all points for $basin")
                    // Now, we need to find all points of the basin
                    findAllPoints(basin, currentPoint, null)
                    allBasins.add(basin)
                    println("Found that for $basin has size ${basin.size}")
                    printBasin(basin)
                    println("--------------------------------------------------")
                }
            }
        }

        // The result is 3 largest basins' sizes multiplied between each other
        return allBasins.sortedByDescending(Basin::size)
            .take(3)
            .fold(1) { acc, basin -> acc * basin.size }
    }

    enum class Color(val code: String){
        BLACK("\u001b[0m\u001b[0m"),
        RED("\u001b[1m\u001b[31m"),
        GREEN("\u001b[1m\u001b[32m")
    }

    private fun printBasin(basin: Basin) {
        var color = Color.BLACK
        field.indices.forEach { row ->
            var s = StringBuilder()
            field[row].indices.forEach{ col ->
                val currentPoint = Point(row, col)

                if (basin.isbase(currentPoint)) {
                    // Apply Green
                    s.append(Color.GREEN.code)
                    s.append(field[currentPoint])
                    color = Color.BLACK
                    s.append(color.code)
                } else {
                    val inBasin = basin.contains(currentPoint)
                    when(color to inBasin) {
                        Color.BLACK to true -> {
                            color = Color.RED
                            s.append(color.code)
                        }
                        Color.RED to false -> {
                            color = Color.BLACK
                            s.append(color.code)
                        }
                    }
                    s.append(field[currentPoint])
                }

            }
            println(s)
        }
    }

    operator fun List<List<Int>>.get(point: Point): Int = this[point.row][point.col]

    enum class Direction {
        TOP, BOTTOM, LEFT, RIGHT
    }


    /**
     * @param direction where it came from, for the recursion. null is for initial
     */
    private fun findAllPoints(basin: Basin, point: Point, direction: Direction?) {
//        direction in arrayOf(null, Direction.TOP)

        // Check Top
        if ((direction == null || direction != Direction.TOP) && point.row > 0) {
            val pointToCheck = point.top()
            if (!basin.contains(pointToCheck) && isPointPartOfBasin(pointToCheck, basin)) {
                basin.addPoint(pointToCheck)
                findAllPoints(basin = basin, point = pointToCheck, Direction.BOTTOM)
            }
        }
        // Check Bottom
        if ((direction == null || direction != Direction.BOTTOM) && point.row < field.size - 1) {
            val pointToCheck = point.bottom()
            if (!basin.contains(pointToCheck) && isPointPartOfBasin(pointToCheck, basin)) {
                basin.addPoint(pointToCheck)
                findAllPoints(basin = basin, point = pointToCheck, Direction.TOP)
            }
        }
        // Check Left
        if ((direction == null || direction != Direction.LEFT) && point.col > 0) {
            val pointToCheck = point.left()
            if (!basin.contains(pointToCheck) && isPointPartOfBasin(pointToCheck, basin)) {
                basin.addPoint(pointToCheck)
                findAllPoints(basin = basin, point = pointToCheck, Direction.RIGHT)
            }
        }
        // Check Right
        if ((direction == null || direction != Direction.RIGHT) && point.col < field[point.row].size - 1) {
            val pointToCheck = point.right()
            if (!basin.contains(pointToCheck) && isPointPartOfBasin(pointToCheck, basin)) {
                basin.addPoint(pointToCheck)
                findAllPoints(basin = basin, point = pointToCheck, Direction.LEFT)
            }
        }
    }

    private fun isPointPartOfBasin(point: Point, basin: Basin): Boolean {
        val pointValue = field[point]

        // Check Top
        if (point.row > 0) {
            val pointToCheck = point.top()
            if (!basin.contains(pointToCheck) && field[pointToCheck] <= pointValue) return false
        }
        // Check Bottom
        if (point.row < field.size - 1) {
            val pointToCheck = point.bottom()
            if (!basin.contains(pointToCheck) && field[pointToCheck] <= pointValue) return false

        }
        // Check Left
        if (point.col > 0) {
            val pointToCheck = point.left()
            if (!basin.contains(pointToCheck) && field[pointToCheck] <= pointValue) return false
        }
        // Check Right
        if (point.col < field[point.row].size - 1) {
            val pointToCheck = point.right()
            if (!basin.contains(pointToCheck) && field[pointToCheck] <= pointValue) return false
        }

        return true
    }

    // The method can be merged with isPointPartOfBasin if to handle empty basin
    private fun isLowestFromAdjacent(num: Int, point: Point): Boolean {

        val (row, col) = point

        if (row > 0) {
            // Check top
            val top = field[point.top()]
            if (top <= num) return false
        }
        if (row < field.size - 1) {
            // Check bottom
            val bottom = field[point.bottom()]
            if (bottom <= num) return false
        }
        if (col > 0) {
            // Check left
            val left = field[point.left()]
            if (left <= num) return false
        }
        if (col < field[row].size - 1) {
            // Check right
            val right = field[point.right()]
            if (right <= num) return false
        }
        return true
    }

}