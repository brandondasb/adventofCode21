fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(depthChecker(input))
//    println(part1(input))
//    println(part2(input))
}

fun depthChecker(input: List<String>): Int {
    val firstMeasurement = input[0]
    var increaseCounter = 0
    input.subList(1, input.size).forEachIndexed { index, depth ->
        val previous = if (index == 0) {
            firstMeasurement
        } else {
            input[index]
        }

        if (hasIncreased(previous, depth)) {
            increaseCounter++
        } else {
            println("hold up:$previous is higher than $depth.")
        }
    }
    return increaseCounter
}


fun hasIncreased(previous: String, currentMeasurement: String): Boolean {
    return (previous.toInt() < currentMeasurement.toInt())
}
/**
 * signal strenght 0-50 stars
 * sonar sweep report(puzzle input)
 *  how quickly the depth increases
 *  count the number of time the depth increase from previous measurement
 *  no measurement before the first measurement
 *
 */
