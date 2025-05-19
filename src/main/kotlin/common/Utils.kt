package common

object Utils {
    fun fromNumberToSpace(n: Int): Int = n / 2

    fun fromNumberToSpot(n: Int): Int = n * 2

    fun IntRange.toIntArray(): IntArray {
        if (last < first)
            return IntArray(0)

        val result = IntArray(last - first + 1)
        var index = 0
        for (element in this)
            result[index++] = element
        return result
    }
}