package adventofcode.day13.model

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