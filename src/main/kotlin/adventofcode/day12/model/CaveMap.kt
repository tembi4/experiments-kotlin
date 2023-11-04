package adventofcode.day12.model

class CaveMap(input: List<String>) {

    private val connectionMap = mutableMapOf<Cave, MutableSet<Cave>>()

    init {
        input.forEach { line ->
            val tokens = line.split("-")

            val cave1 = Cave(tokens[0])
            val cave2 = Cave(tokens[1])

            val value1: MutableSet<Cave> = connectionMap[cave1] ?: mutableSetOf()
            value1.add(cave2)
            connectionMap[cave1] = value1

            val value2: MutableSet<Cave> = connectionMap[cave2] ?: mutableSetOf()
            value2.add(cave1)
            connectionMap[cave2] = value2
        }
    }

    fun findAllDistinctPaths(): Set<Path> {
        val possiblePaths = mutableSetOf<Path>()
        connectionMap[Cave.start()]?.forEach { cave ->
            goNext(cave = cave, path = Path(Cave.start()), possiblePaths = possiblePaths)
        }
        return possiblePaths.toSet()
    }

    private fun goNext(cave: Cave, path: Path, possiblePaths: MutableSet<Path>) {
        path.add(cave)
        if (cave.isNotEnd) {
            connectionMap[cave]?.forEach { connectedCave ->
                if (isCheckNext(cave = connectedCave, path = path)) {
                    val newPath = Path(path)
                    goNext(cave = connectedCave, path = newPath, possiblePaths = possiblePaths)
                    if (newPath.contains(Cave.end())) {
                        possiblePaths.add(newPath)
                    }
                }
            }
        }
    }



    private fun isCheckNext(cave: Cave, path: Path) =
        ((cave.isBig || !path.contains(cave))
                && (cave.isEnd || connectionMap.containsKey(cave)))  // Check if not a dead-end

    fun findAllDistinctPathsVisitingSingleCavesTwice(): Set<Path> {
        val possiblePaths = mutableSetOf<Path>()
        connectionMap[Cave.start()]?.forEach { cave ->
            goNext2(cave = cave, path = Path(Cave.start()), possiblePaths = possiblePaths)
        }
        return possiblePaths.toSet()
    }

    private fun goNext2(cave: Cave, path: Path, possiblePaths: MutableSet<Path>) {
        path.add(cave)
        if (cave.isNotEnd) {
            connectionMap[cave]!!.forEach { connectedCave ->
                if (isCheckNext2(cave = connectedCave, path = path)) {
                    val newPath = Path(path)
                    goNext2(cave = connectedCave, path = newPath, possiblePaths = possiblePaths)
                    if (newPath.contains(Cave.end())) { // Can be replaced with last with End...?
                        possiblePaths.add(newPath)
                    }
                }
            }
        }
    }


    private fun isCheckNext2(cave: Cave, path: Path): Boolean {
        if (cave.isStart) {
            return false
        } else if (cave.isBig) {
            return true
        } else {
            // Small cave
            val containsTimes = path.containsTimes(cave)
            if (containsTimes == 0) {
                return true
            } else if (containsTimes == 1) {
                // Already visited a small cave
                if (!path.containsSmallVisitedTwice()) {
                    return true
                } else {
                    return false
                }
            }
        }
        return false
    }
}