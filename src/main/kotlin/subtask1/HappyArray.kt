package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {

        if (sadArray.isEmpty()) {
            return sadArray
        }

        val happyNumbers = arrayListOf<Int>()
        happyNumbers.add(sadArray[0])
        for (i in 1 until sadArray.size - 1) {
            if (sadArray[i] < (sadArray[i-1] + sadArray[i+1])) {
                happyNumbers.add(sadArray[i])
            }
        }
        happyNumbers.add(sadArray[sadArray.size - 1])
        println("happyNumbers : $happyNumbers")

        return happyNumbers.toIntArray()
    }
}
