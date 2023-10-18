package adventofcode.day09

class Basin(private val lowLocation: Point) {
    private var points: MutableSet<Point> = mutableSetOf(lowLocation)

    val size: Int
        get() = points.size

    fun isbase(point: Point): Boolean = point == lowLocation

//    operator fun plus(point: Point): Basin {
//        points += point
//        return this
//    }

    fun addPoint(point: Point) {
        points += point
    }

    fun contains(point: Point) = points.contains(point)

    override fun toString(): String {
        return "Basin$lowLocation"
    }

}