package adventofcode.day09

class Field(val values: List<List<Int>>) {
    // TODO: create a fun to find the lowest points (can be taken from Puzzle Part One)



    operator fun List<List<Int>>.get(point: Point): Int = this[point.row][point.col]


    private fun printBasin(basin: Basin) {
        var color = BasinCalculator.Color.BLACK
        values.indices.forEach { row ->
            val s = StringBuilder()
            values[row].indices.forEach{ col ->
                val currentPoint = Point(row, col)

                if (basin.isbase(currentPoint)) {
                    // Apply Green
                    s.append(BasinCalculator.Color.GREEN.code)
                    s.append(values[currentPoint])
                    color = BasinCalculator.Color.BLACK
                    s.append(color.code)
                } else {
                    val inBasin = basin.contains(currentPoint)
                    when(color to inBasin) {
                        BasinCalculator.Color.BLACK to true -> {
                            color = BasinCalculator.Color.RED
                            s.append(color.code)
                        }
                        BasinCalculator.Color.RED to false -> {
                            color = BasinCalculator.Color.BLACK
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