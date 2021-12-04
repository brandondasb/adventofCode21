fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var depth = 0
        input.forEach { instruction ->
            val command = getCommand(instruction)
            when (command.first) {
                "forward" -> horizontal += command.second
                "down" -> depth += command.second
                "up" -> depth -= command.second
            }

        }
        return horizontal * depth
    }

    fun part2(input: List<Int>): Int {
        return input.size
    }

    val input = readInput("Day02")
    println(part1(input))
//    println(part2(input.map { it.toInt() }))
}


fun getCommand(command: String): Pair<String, Int> {
    val direction = command.split(" ")[0]
    val distance = command.split(" ")[1].toInt()
    return Pair(direction, distance)
}

