package adventofcode.day13

import adventofcode.day13.model.InputReader

class Puzzle {
    companion object {
        fun calculatePart1(input: List<String>): Int {

            val (field, folds) = InputReader.read(input)
//            print(field)
//            println("===============================================================")
            val firstFold = folds.first()

            field.applyFold(fold = firstFold)
//            print(field)

//            folds.forEach { field.applyFold(it) }
//            print(field)

            return field.dotsCount()
        }
        fun calculatePart2(input: List<String>): Int {

            val (field, folds) = InputReader.read(input)
            folds.forEach { field.applyFold(it) }
            print(field)

            return field.dotsCount()
        }
    }

}