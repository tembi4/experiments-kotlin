package adventofcode.day12

import adventofcode.day12.model.CaveMap
import adventofcode.day12.model.Path

class Puzzle {

    companion object {
        fun calculatePart1(input: List<String>): Int {
            val caveMap = CaveMap(input = input)

            val allDistinctPaths = caveMap.findAllDistinctPaths()
//            allDistinctPaths.sortedBy(Path::toString).forEach{ path -> println(path) }

            return allDistinctPaths.size
        }
    }
}