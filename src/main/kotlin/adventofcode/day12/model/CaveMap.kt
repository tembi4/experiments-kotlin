package adventofcode.day12.model

class CaveMap {

    private val connectionMap = mutableMapOf<Cave, MutableSet<Cave>>()

    constructor(input: List<String>) {
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
                if ((connectedCave.isBig || !path.contains(connectedCave))
                    && (connectedCave.isEnd || connectionMap.containsKey(connectedCave)) // Check if not a dead-end
                ) {
                    val newPath = path.copy()
                    goNext(cave = connectedCave, path = newPath, possiblePaths = possiblePaths)
                    if (newPath.contains(Cave.end())) {
                        possiblePaths.add(newPath)
                    }
                }
            }
        }
    }
}