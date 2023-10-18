package adventofcode

import java.io.File
import java.lang.IllegalArgumentException


/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("""src/test/resources""", "$name.txt")
    .readLines()
