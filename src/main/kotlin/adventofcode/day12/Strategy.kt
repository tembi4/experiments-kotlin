package adventofcode.day12

import adventofcode.day12.model.Cave
import adventofcode.day12.model.Path

open abstract class Strategy(protected val connectionMap: MutableMap<Cave, MutableSet<Cave>>) {

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
            connectionMap[cave]!!.forEach { connectedCave ->
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

    protected abstract fun isCheckNext(cave: Cave, path: Path): Boolean
}