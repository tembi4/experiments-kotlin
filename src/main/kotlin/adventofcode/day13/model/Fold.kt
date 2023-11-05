package adventofcode.day13.model

data class Fold(val direction: Char, val value: Int) {
    override fun toString() = "fold along $direction=$value"
}