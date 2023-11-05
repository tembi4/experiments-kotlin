package adventofcode.day13.model

class InputReader() {

    companion object {
        private val dotRegExp = """(\d+),(\d+)""".toRegex()
        private val foldRegExp = """fold along ([x,y])=(\d+)""".toRegex()

        fun read(input: List<String>): Pair<Field, List<Fold>> {
            val (dotsInput, foldsInput) = input.partition { line -> line.matches(dotRegExp) }
            val dots = dotsInput
                .map { dotRegExp.find(it)!!.destructured }
                .map { (x, y) -> Dot(x.toInt(), y.toInt()) }
                .toSet()
            val folds = foldsInput
                .filter { it.isNotBlank() }
                .map { foldRegExp.find(it)!!.destructured }
                .map { (direction, value) -> Fold(direction[0], value.toInt()) }

            return Pair(Field(dots), folds)
        }

    }

}