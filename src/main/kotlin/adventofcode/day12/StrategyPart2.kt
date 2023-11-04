package adventofcode.day12

import adventofcode.day12.model.Cave
import adventofcode.day12.model.Path

class StrategyPart2(private val connectionMap: MutableMap<Cave, MutableSet<Cave>>): Strategy() {

    override fun findAllDistinctPaths(): Set<Path> {
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
            return when(containsTimes) {
                0 -> true
                1 -> !path.containsSmallVisitedTwice()
                else -> false
            }
        }
    }

}