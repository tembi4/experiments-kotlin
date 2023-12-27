package adventofcode.day13.model

data class Fold(val direction: Char, val value: Int) {
    override fun toString() = "fold along $direction=$value"
}

/**
 * (0,0) --------> x
 * |
 * |
 * |
 * |
 * y
 */
data class Dot(var x: Int, var y: Int) {
    override fun toString() = "($x,$y)"
}