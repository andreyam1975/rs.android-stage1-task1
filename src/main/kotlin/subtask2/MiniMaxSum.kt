package subtask2

import services.Utils

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {

        Utils.printArray("inputArray", input)

        val res = IntArray(2)

        val min = input.min()
        val max = input.max()

        var sumOfMin = 0
        var sumOfMax = 0

        input.forEach {
            if ( it != max) {
                sumOfMin += it
            }
            if ( it != min) {
                sumOfMax += it
            }
        }

        res[0] = sumOfMin
        res[1] = sumOfMax

        Utils.printArray("resultArray", res)

        return res
    }
}
