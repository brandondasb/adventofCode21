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

    fun instructionToCommand(
        input: List<String>,
        horizontal: Int,
        depth: Int,
        aim: Int
    ): Pair<Int, Int> {
        var horizontal1 = horizontal
        var depth1 = depth
        var aim1 = aim
        input.forEach { instruction ->
            val command = getCommand(instruction)
            when (command.first) {
                "forward" -> {
                    horizontal1 += command.second
                    depth1 += aim1 * command.second
                }
                "down" -> aim1 += command.second
                "up" -> aim1 -= command.second
            }
        }
        return Pair(depth1, horizontal1)
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        var depth = 0
        var horizontal = 0
        val pair = instructionToCommand(input, horizontal, depth, aim)
        depth = pair.first
        horizontal = pair.second
        return horizontal * depth
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}



fun getCommand(command: String): Pair<String, Int> {
    val direction = command.split(" ")[0]
    val distance = command.split(" ")[1].toInt()
    return Pair(direction, distance)
}

