import java.io.File

fun main() {

    fun result(input: String, windowSize: Int): Int = input
        .windowed(windowSize)
        .map { it.toSet().size }
        .indexOf(windowSize) + windowSize

    fun part1(input: String): Int = result(input, 4)

    fun part2(input: String): Int = result(input, 14)

    val input = File("src/inputs/day6.txt").readText()
    println(part1(input))
    println(part2(input))
}
