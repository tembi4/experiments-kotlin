package adventofcode.day12.model

data class Cave(val name: String) {

    val isBig = name.uppercase() == name

    val isEnd = name == "end"
    val isNotEnd = name != "end"
    val isNotStart = name != "start"

    override fun toString() = name

    companion object {
        fun start() = Cave(name = "start")
        fun end() = Cave(name = "end")
    }
}