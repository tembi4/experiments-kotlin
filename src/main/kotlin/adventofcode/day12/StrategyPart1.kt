package adventofcode.day12

import adventofcode.day12.model.Cave
import adventofcode.day12.model.Path

class StrategyPart1(connectionMap: MutableMap<Cave, MutableSet<Cave>>): Strategy(connectionMap) {

    override fun isCheckNext(cave: Cave, path: Path) =
        ((cave.isBig || !path.contains(cave))
                && (cave.isEnd || connectionMap.containsKey(cave)))  // Check if not a dead-end
}