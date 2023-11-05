package adventofcode.day12

import adventofcode.day12.model.Cave
import adventofcode.day12.model.Path

class StrategyPart2(connectionMap: MutableMap<Cave, MutableSet<Cave>>): Strategy(connectionMap) {

    override fun isCheckNext(cave: Cave, path: Path): Boolean {
        if (cave.isStart) {
            return false
        } else if (cave.isBig) {
            return true
        } else {
            // Small cave
            val containsTimes = path.containsTimes(cave)
            return when(containsTimes) {
                0 -> true
                1 -> path.notContainsSmallVisitedTwice()
                else -> false
            }
        }
    }

}