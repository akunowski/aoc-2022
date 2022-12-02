fun main() {

    fun roundResult(pair: Pair<Char, Char>) =
        when (pair) {
            'A' to 'B', 'B' to 'C', 'C' to 'A' -> 6
            'A' to 'A', 'B' to 'B', 'C' to 'C' -> 3
            else -> 0
        }

    fun shapeValue(shape: Char): Int =
        when (shape) {
            'A' -> 1
            'B' -> 2
            'C' -> 3
            else -> throw Error()
        }

    fun calculateScore(pair: Pair<Char, Char>): Int = roundResult(pair) + shapeValue(pair.second)

    fun normalizeShapesPart1(myShape: Char): Char =
        when (myShape) {
            'X' -> 'A'
            'Y' -> 'B'
            'Z' -> 'C'
            else -> throw Error()
        }

    fun normalizeShapesPart2(pair: Pair<Char, Char>): Char =
        when (pair.second) {
            'X' -> {
                when (pair.first) {
                    'A' -> 'C'
                    'B' -> 'A'
                    else -> 'B'
                }
            }

            'Z' -> {
                when (pair.first) {
                    'A' -> 'B'
                    'B' -> 'C'
                    else -> 'A'
                }
            }

            else -> pair.first
        }


    fun part1(input: List<String>): Int =
        input
            .map { it[0] to normalizeShapesPart1(it[2]) }
            .sumOf { calculateScore(it) }


    fun part2(input: List<String>): Int =
        input
            .map { it[0] to normalizeShapesPart2(it[0] to it[2]) }
            .sumOf { calculateScore(it) }


    val input = readInput("inputs/day2")
    println(part1(input))
    println(part2(input))
}
