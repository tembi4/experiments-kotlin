package adventofcode.day12.model

import adventofcode.day12.Strategy
import adventofcode.day12.StrategyPart1
import adventofcode.day12.StrategyPart2

class CaveMap(input: List<String>) {

    private val strategyPart1: StrategyPart1
    private val strategyPart2: StrategyPart2

    init {
        val connectionMap = mutableMapOf<Cave, MutableSet<Cave>>()
        input
            .map { it.split("-") }
            .map { Pair(Cave(it[0]), Cave(it[1])) }
            .forEach { (cave1, cave2) ->
                connectionMap.addConnection(cave = cave1, caveToAdd = cave2)
                connectionMap.addConnection(cave = cave2, caveToAdd = cave1)
            }
        strategyPart1 = StrategyPart1(connectionMap)
        strategyPart2 = StrategyPart2(connectionMap)
    }

    private fun MutableMap<Cave, MutableSet<Cave>>.addConnection(cave: Cave, caveToAdd: Cave) {
        val connectedCaves: MutableSet<Cave> = this[cave] ?: mutableSetOf()
        connectedCaves.add(caveToAdd)
        this[cave] = connectedCaves
    }

    fun findAllDistinctPaths(part: Int) = strategy(part).findAllDistinctPaths()

    private fun strategy(part: Int) = when (part) {
        1 -> strategyPart1
        2 -> strategyPart2
        else -> TODO("Only 1 or 2 supported yet")
    }
}