package easy

import kotlin.IllegalArgumentException

/**
 * LeetCode №67 Easy
 * Given two binary strings a and b, return their sum as a binary string.
 * Constraints:
 *  1 <= a.length, b.length <= 104
 *  a and b consist only of '0' or '1' characters.
 *  Each string does not contain leading zeros except for the zero itself.
 */

fun main() {
    val a = "111"
    val b = "11"
    val sum = addBinary(a, b)
    println(sum)
}

fun addBinary(a: String, b: String): String {
    if (!validate(a) || !validate(b)) throw IllegalArgumentException()
    var result = ""
    var carry = 0
    var i = a.length - 1
    var j = b.length - 1

    while (i >= 0 || j >= 0 || carry > 0) {
        val digitA = if (i >= 0) a[i] - '0' else 0
        val digitB = if (j >= 0) b[j] - '0' else 0
        val sum = digitA + digitB + carry

        result = "${sum % 2}$result"
        carry = sum / 2
        i--
        j--
    }

    return result
}

private fun validate(value: String): Boolean {
    value.forEach { if (it != '1' && it != '0') return false }
    return value.length in 1..10000
}