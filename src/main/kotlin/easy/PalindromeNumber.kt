package easy

/**
 * LeetCode №9 Easy
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * Constraints: -2^31 <= x <= 2^31 - 1
 */

fun main() {
    val number = 11
    println(isPalindrome(number))
}

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false
    val s = x.toString()
    var i = 0
    var j = s.length - 1
    while (i < j) {
        if (s[j] != s[i]) return false
        i++
        j--
    }
    return true
}
