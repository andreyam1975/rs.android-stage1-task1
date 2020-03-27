package subtask3

class BillCounter {

    private val fairlySplit = "bon appetit"

    /**
     * The output could be "bon appetit" when bill is fair or the string with number(e.g "10"),
     * which equal the difference between the amount [b] and half of fair bill
     */
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {

        var fairBill = 0

        for (i in bill.indices) {
            if (i != k) {
                fairBill += bill[i]
            }
        }

        return if (fairBill / 2 == b) {
            fairlySplit
        } else {
            "${b - fairBill / 2}"
        }

    }
}
