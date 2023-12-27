package adventofcode

import java.io.File


/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("""src/test/resources""", "$name.txt")
    .readLines()

fun countSymbols(s: String): Map<Char, Int> {
    return s.groupingBy { it }.eachCount()
}

fun countSymbolsAsLongMutable(s: String) = s.groupingBy { it }.eachCount()
    .map {
        it.key to it.value.toLong()
    }.toMap().toMutableMap()