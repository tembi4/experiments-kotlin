package adventofcode.day12

import adventofcode.day12.model.Path

open abstract class Strategy {
    abstract fun findAllDistinctPaths(): Set<Path>
}