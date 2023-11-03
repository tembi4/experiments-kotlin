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

        /*
        * After reviewing the available paths, you realize you might have time to visit a single small cave twice.
        * Specifically, big caves can be visited any number of times, a single small cave can be visited at most twice,
        * and the remaining small caves can be visited at most once. However, the caves named start and end can only be
        * visited exactly once each: once you leave the start cave, you may not return to it, and once you reach
        * the end cave, the path must end immediately.
        * */
        fun calculatePart2(input: List<String>): Any {
            val caveMap = CaveMap(input = input)

            val allDistinctPaths = caveMap.findAllDistinctPathsVisitingSingleCavesTwice()
            allDistinctPaths.sortedBy(Path::toString).forEach { path -> println(path) }

            return allDistinctPaths.size
        }
    }
}