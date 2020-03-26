package services

class Utils {

    companion object {
        fun printArray(arrayName: String, array: IntArray) {
            print("$arrayName : [")
            for (i in 0 until array.size - 1) {
                print("${array[i]}, ")
            }
            print("${array[array.size - 1]}]")
            println()
        }
    }
}