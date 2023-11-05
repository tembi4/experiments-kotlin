package adventofcode.day13.model

import kotlin.reflect.KMutableProperty1

class Field(private var dots: Set<Dot>) {

    private var sizeX: Int = dots.maxOf { it.x }
    private var sizeY: Int = dots.maxOf { it.y }

    override fun toString(): String {
        val sb = StringBuilder()
        for (y in 0 .. sizeY) {
            for (x in 0 .. sizeX) {
                val isContain = dots.contains(Dot(x, y))
                sb.append(
                    when(isContain) {
                        true -> "#"
                        false -> " "
                    }
                )
            }
            sb.append("\n")
        }
        return sb.toString()
    }

    fun applyFold(fold: Fold) {
        foldByValue(fold.value, when(fold.direction) {
            'x' -> Dot::x
            'y' -> Dot::y
            else -> TODO("Only x and y are supported")
        })
    }

    private fun foldByValue(value: Int, axis: KMutableProperty1<Dot, Int>) {
        val dotsAsList = dots.toList()
        dotsAsList.filter { axis.get(it) > value }
            .forEach {
                axis.set(it, 2 * value - axis.get(it))
            }
        dots = dotsAsList.toSet()
        sizeY -= value
    }

    fun dotsCount() = dots.size

}