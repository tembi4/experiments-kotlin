package adventofcode.day12.model

data class Cave(val name: String) {

    val isBig = name.uppercase() == name
    val isSmall = name.lowercase() == name

    val isStart = name == "start"
    val isEnd = name == "end"
    val isNotEnd = name != "end"

    override fun equals(other: Any?) = when {
        other == null -> false
        other is Cave -> name == other.name
        else -> false
    }

    override fun hashCode() = name.hashCode()

    override fun toString() = name

    companion object {
        fun start() = Cave(name = "start")
        fun end() = Cave(name = "end")
    }
}