package adventofcode.day12.model

class Path {

    private val cavePoints = mutableListOf<Cave>()

    constructor(vararg caves: Cave) {
        cavePoints.addAll(caves)
    }

    fun add(cave: Cave) {
        cavePoints.add(element = cave)
    }

    fun contains(cave: Cave) = cavePoints.contains(cave)

    fun copy(): Path {
        val path = Path()
        path.cavePoints.addAll(cavePoints)
        return path
    }

    override fun toString() = cavePoints.toString()
}