package subtask1

import services.Utils

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {

        if (sadArray.isEmpty()) {
            return sadArray
        }

        var intArray = sadArray.copyOf()

        Utils.printArray("sadArray", sadArray)

        while (!isArrayHappy(intArray)) {

            val happyNumbers = arrayListOf<Int>()
            happyNumbers.add(intArray[0])
            for (i in 1 until intArray.size - 1) {
                if (intArray[i] < (intArray[i-1] + intArray[i+1])) {
                    happyNumbers.add(intArray[i])
                }
            }
            happyNumbers.add(intArray[intArray.size - 1])

            intArray = happyNumbers.toIntArray()
        }

        Utils.printArray("happyArray", intArray)

        return intArray
    }

    private fun isArrayHappy(array: IntArray) : Boolean {

        for (i in 1 until array.size - 1) {
            if (array[i] > (array[i-1] + array[i+1])) {
                return false
            }
        }

        return true
    }
}
