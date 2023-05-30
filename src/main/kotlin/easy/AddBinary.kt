package easy

import kotlin.IllegalArgumentException

/**
 * Given two binary strings a and b, return their sum as a binary string.
 * Constraints:
 *  1 <= a.length, b.length <= 104
 *  a and b consist only of '0' or '1' characters.
 *  Each string does not contain leading zeros except for the zero itself.
 */

fun main() {
    val a = "11"
    val b = "1"
    val sum = addBinary(a, b)
    println(sum)
}

fun addBinary(a: String, b: String): String {
    if (!validate(a) || !validate(b)) throw IllegalArgumentException()
    var sb = ""
    var carry = 0
    var i = a.length - 1
    var j = b.length - 1

    while (i >= 0 || j >= 0 || carry > 0) {
        val digitA = if (i >= 0) a[i] - '0' else 0
        val digitB = if (j >= 0) b[j] - '0' else 0
        val sum = digitA + digitB + carry

        sb = "${sum % 2}$sb"
        carry = sum / 2
        i--
        j--
    }

    return sb
}

private fun validate(value: String): Boolean {
    value.forEach { if (it != '1' && it != '0') return false }
    return value.length in 1..10000
}