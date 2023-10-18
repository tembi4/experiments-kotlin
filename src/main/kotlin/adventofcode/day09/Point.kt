package adventofcode.day09

data class Point(val row: Int, val col: Int) {

    fun top(): Point = Point(row = row - 1, col = col)
    fun bottom(): Point = this.copy(row = row + 1)
    fun left(): Point = this.copy(col = col - 1)
    fun right(): Point = this.copy(col = col + 1)

    override fun toString(): String = "($row,$col)"
}
