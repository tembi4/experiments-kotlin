package adventofcode.day09

class Basin(private val lowLocation: Point) {
    private var points: MutableSet<Point> = mutableSetOf(lowLocation)

    val size: Int
        get() = points.size

    fun isBase(point: Point): Boolean = point == lowLocation

    fun addPoint(point: Point) {
        points += point
    }

    fun contains(point: Point) = points.contains(point)

    fun notContains(point: Point) = !contains(point)

    override fun toString(): String {
        return "Basin$lowLocation"
    }

}