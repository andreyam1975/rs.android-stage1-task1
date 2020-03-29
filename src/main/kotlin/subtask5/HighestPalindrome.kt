package subtask5

import services.Utils
import java.lang.Exception

class HighestPalindrome {

    /**
     * returns string that is palindrome with highest values; this output getting from input string
     * [digitString] by [k] changes
     */
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {

        var resString  ="-1"

        if (getNumberOfChanges(digitString) > k) {
            println("Convert string to Palindrome impossible, due to needed number of changes bigger than given.")
            return resString
        }

        val intArray = IntArray(n)

        try {
            for (i in digitString.indices) {
                intArray[i] = Integer.parseInt(digitString.subSequence(i, i + 1).toString())
            }
        } catch (e: Exception) {
            println("Convert string to Palindrome impossible, due to input string contains not only digits.")
            return resString
        }

        //
        var numberOfChanges = 0

        val copyIntArray = intArray.copyOf()

        for (i in 0..((copyIntArray.size / 2) - 1)) {
            if (copyIntArray[i] != copyIntArray[copyIntArray.lastIndex - i]) {
                if (copyIntArray[i] < copyIntArray[copyIntArray.lastIndex - i]) {
                    copyIntArray[i] = copyIntArray[copyIntArray.lastIndex - i]
                    numberOfChanges++
                } else {
                    copyIntArray[copyIntArray.lastIndex - i] = copyIntArray[i]
                    numberOfChanges++
                }
            }
        }

        var l = 1
        while (l <= k - numberOfChanges) {

            val min = copyIntArray.min()
            var indexOfMin = 0
            for (i in copyIntArray.indices) {
                if (copyIntArray[i] == min) {
                    indexOfMin = i
                }
            }

            if (intArray[indexOfMin] != min){
                copyIntArray[indexOfMin] = 9
                copyIntArray[copyIntArray.lastIndex - indexOfMin] = 9
                l++
            } else {
                copyIntArray[indexOfMin] = 9
                copyIntArray[copyIntArray.lastIndex - indexOfMin] = 9
                l += 2
            }

        }

        Utils.printArray("IntArray", copyIntArray)

        var palindrome = ""

        copyIntArray.forEach { palindrome += it }

        resString = palindrome

        println("palindrome : $resString")

        return resString
    }

    /**
     *  return number of changes needed to obtain Palindrome from [digitString]
     */
    private fun getNumberOfChanges(digitString: String) : Int {

        var res = 0

        for (i in 0..((digitString.length / 2) - 1)) {
            if (digitString[i] != digitString[digitString.lastIndex - i]) {
                res++
            }
        }

        println("number of changes : $res")

        return res

    }
}
