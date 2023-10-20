package adventofcode.day09

class Field(val values: List<List<Int>>) {
    // TODO: create a fun to find the lowest points (can be taken from Puzzle Part One)

    // TODO: hide values and create scope function

    private val size = values.size

    private fun colSize(row: Int) = values[row].size
    operator fun List<List<Int>>.get(point: Point) = this[point.row][point.col]
    operator fun get(point: Point): Int = values[point.row][point.col]

    private fun hasTop(point: Point) = point.row > 0
    fun hasBottom(point: Point) = point.row < size - 1
    fun hasLeft(point: Point) = point.col > 0
    fun hasRight(point: Point) = point.col < colSize(point.row) - 1

    fun hasOnSide(side: Sides, point: Point) = when(side) {
        Sides.TOP -> hasTop(point)
        Sides.BOTTOM -> hasBottom(point)
        Sides.LEFT -> hasLeft(point)
        Sides.RIGHT -> hasRight(point)
    }

    private fun printBasin(basin: Basin) {
        var color = Color.BLACK
        values.indices.forEach { row ->
            val s = StringBuilder()
            values[row].indices.forEach { col ->
                val currentPoint = Point(row, col)

                if (basin.isbase(currentPoint)) {
                    // Apply Green
                    s.append(Color.GREEN.code)
                    s.append(values[currentPoint])
                    color = Color.BLACK
                    s.append(color.code)
                } else {
                    val inBasin = basin.contains(currentPoint)
                    when (color to inBasin) {
                        Color.BLACK to true -> {
                            color = Color.RED
                            s.append(color.code)
                        }

                        Color.RED to false -> {
                            color = Color.BLACK
                            s.append(color.code)
                        }
                    }
                    s.append(values[currentPoint])
                }

            }
            println(s)
        }
    }



}

enum class Color(val code: String) {
    BLACK("\u001b[0m\u001b[0m"),
    RED("\u001b[1m\u001b[31m"),
    GREEN("\u001b[1m\u001b[32m")
}