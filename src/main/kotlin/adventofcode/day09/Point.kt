package adventofcode.day09

data class Point(val row: Int, val col: Int) {

    private fun top(): Point = Point(row = row - 1, col = col)
    private fun bottom(): Point = this.copy(row = row + 1)
    private fun left(): Point = this.copy(col = col - 1)
    private fun right(): Point = this.copy(col = col + 1)

    fun onSide(side: Side) = when(side) {
        Side.TOP -> top()
        Side.BOTTOM -> bottom()
        Side.LEFT -> left()
        Side.RIGHT -> right()
    }

    override fun toString(): String = "($row,$col)"
}
