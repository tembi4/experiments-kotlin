package adventofcode.day12.model

class Path {

    private val cavePoints = mutableListOf<Cave>()

    constructor(cave: Cave) {
        cavePoints.add(cave)
    }

    constructor(path: Path) {
        this.cavePoints.addAll(path.cavePoints)
    }

    fun add(cave: Cave) {
        cavePoints.add(element = cave)
    }

    fun contains(cave: Cave) = cavePoints.contains(cave)
    override fun toString() = cavePoints.toString()

    // TODO: Map can be used here
    fun containsTimes(caveToCheck: Cave) = cavePoints.count { it.name == caveToCheck.name }


    fun containsSmallVisitedTwice() =
        this.cavePoints.filter { !it.isBig }.groupingBy { it }.eachCount().filter { it.value > 1 }.isNotEmpty()

}