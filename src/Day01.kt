fun main() {
    fun part1(input: Int): Int {
        return input
    }

    fun part2(input: List<Int>): Int {
        var increaseCounter = 0
        val sums = getSumList(input)
        sums.forEachIndexed { index, depth ->
            if (index > 0) {
                if (depth > sums[index - 1]) {
                    increaseCounter++
                }
            }
        }
        return increaseCounter
    }


    // test if implementation meets criteria from the description, like:
    //  val testInput = readInput("Day01_test")
    //    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(depthChecker(input)))
    println(part2(input.map { it.toInt() }))
}

fun getSumList(input: List<Int>): List<Int> {
    val sum: MutableList<Int> = mutableListOf()
    for (depths in 0 until input.size - 2) {
        sum.add(input[depths] + input[depths + 1] + input[depths + 2])
    }
    return sum
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
        }
    }
    return increaseCounter
}

fun hasIncreased(previous: String, currentMeasurement: String): Boolean {
    return (previous.toInt() < currentMeasurement.toInt())
}

