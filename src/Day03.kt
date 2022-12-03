fun main() {

    fun compartmentsItems(items: String): Pair<Set<Char>, Set<Char>> {
        val leftCompartment = HashSet<Char>()
        val rightCompartment = HashSet<Char>()

        for (i: Int in 0 until items.length / 2) {
            leftCompartment.add(items[i])
            rightCompartment.add(items[items.length - i - 1])
        }
        return leftCompartment to rightCompartment
    }

    fun priority(it: Char): Int = if (it.code > 90) it.code - 96 else it.code - 38

    fun priority(it: Set<Char>): Int = it.sumOf { priority(it) }

    fun intersectAll(it: List<Set<Char>>): Set<Char> =
        it.reduce { first, second -> first.intersect(second) }

    fun part1(input: List<String>): Int =
        input
            .map { compartmentsItems(it) }
            .map { it.first.intersect(it.second) }
            .sumOf { priority(it) }

    fun part2(input: List<String>): Int =
        input
            .map { compartmentsItems(it) }
            .map { it.first.plus(it.second) }
            .windowed(3, 3) { intersectAll(it) }
            .sumOf { priority(it) }

    val input = readInput("inputs/day3")
    println(part1(input))
    println(part2(input))
}
