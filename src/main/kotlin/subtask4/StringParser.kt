package subtask4

class StringParser {

    /**
     *  Method returns an Array of Strings. Each element of the array contains substring between
     *  the open-close bracket in [inputString], that might contain the following brackets: [], <>, ().
     */
    fun getResult(inputString: String): Array<String> {

        val result = getSequences(inputString)

        val output : Array<String> = Array(result.size) {""}

        for (i in output.indices) {
            output[i] = result[i]
        }

        return output
    }

    private fun getSequences(input: String) : ArrayList<String> {
        val result = ArrayList<String>()

        var i = 0
        var openP: Char
        var closedP: Char

        while (i < input.length - 1) {

            when (input[i]) {
                 '<' -> {
                     openP = '<'
                     closedP = '>'
                     result.add(input.substring(input.indexOf(openP, i) + 1, input.indexOf(closedP, i)))
                }
                '(' -> {
                    openP = '('
                    closedP = ')'
                    result.add(input.substring(input.indexOf(openP, i) + 1, input.indexOf(closedP, i)))
                }
                '[' -> {
                    openP = '['
                    closedP = ']'
                    result.add(input.substring(input.indexOf(openP, i) + 1, input.indexOf(closedP, i)))
                }
            }
            i++
        }

        result.forEach { println(it) }

        return result
    }

}
