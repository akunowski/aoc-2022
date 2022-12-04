fun main() {

    fun toRange(s: List<String>): IntRange = s[0].toInt()..s[1].toInt()

    fun isOverlapping(first: IntRange, second: IntRange): Boolean {
        val union = first union second
        return union == first.toSet() || union == second.toSet()
    }

    fun part1(input: List<String>): Int =
        input
            .map { it.split(",") }
            .map { it[0].split("-") to it[1].split("-") }
            .map { toRange(it.first) to toRange(it.second) }
            .count { isOverlapping(it.first, it.second) }

    fun part2(input: List<String>): Int =
        input
            .map { it.split(",") }
            .map { it[0].split("-") to it[1].split("-") }
            .map { toRange(it.first) to toRange(it.second) }
            .map { it.first intersect it.second }
            .count { it.isNotEmpty() }

    val input = readInput("inputs/day4")
    println(part1(input))
    println(part2(input))
}
