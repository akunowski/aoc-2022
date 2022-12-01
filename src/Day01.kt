import java.io.File

fun main() {
    fun groupElvesCalories(input: String) =
        input.split("\r\n\r\n")
            .map { caloriesGroup ->
                caloriesGroup.lines().map { it.toInt() }
            }

    fun part1(input: String): Int =
        groupElvesCalories(input)
            .maxOf { it.sum() }

    fun part2(input: String): Int =
        groupElvesCalories(input)
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()


    val input = File("src/inputs/day1.txt").readText()
    println(part1(input))
    println(part2(input))
}
