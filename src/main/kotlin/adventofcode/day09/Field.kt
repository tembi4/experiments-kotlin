package adventofcode.day09

import adventofcode.day09.Side.*

class Field(private val values: List<List<Int>>) {
    // TODO: hide values and create scope function

    val size = values.size

    fun colSize(row: Int) = values[row].size
    operator fun List<List<Int>>.get(point: Point) = this[point.row][point.col]
    operator fun get(point: Point): Int = values[point.row][point.col]

    fun isValid(point: Point) = get(point) != 9

    private fun hasOnSide(side: Side, point: Point) = when (side) {
        TOP -> point.row > 0
        BOTTOM -> point.row < size - 1
        LEFT -> point.col > 0
        RIGHT -> point.col < colSize(point.row) - 1
    }

    fun pointToCheck(side: Side, point: Point): Point? {
        var result: Point? = null
        if (hasOnSide(side = side, point = point)) {
            val pointToCheck = point.onSide(side = side)
            if (isValid(point = pointToCheck)) {
                result = pointToCheck
            }
        }
        return result
    }

    private fun printBasin(basin: Basin) {
        var color = Color.BLACK
        values.indices.forEach { row ->
            val s = StringBuilder()
            values[row].indices.forEach { col ->
                val currentPoint = Point(row, col)

                if (basin.isBase(currentPoint)) {
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