/**
 * [cci-1.1] Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures.
 */

// using the API
s.distinct == s.length
 
// An iterative version, time complexity O(n*n)
def isUniqueCharsOne(s: String): Boolean = {
  for (i <- 0 until s.length)
    for (j <- i+1 until s.length)
      if (s.charAt(i) == s.charAt(j))
        return false
  true
}
 
// Using a map, time complexity O(n)
def isUniqueCharsTwo(s: String): Boolean = {
  var hMap: Map[Char, Boolean] = Map()
  s foreach (c => {
    if (hMap.getOrElse(c, false)) return false
    hMap += (c -> true)
  })
  true
}
 
// Using a bit vector, we assume that string only
// contains a to z letters
def isUniqueCharsThree(s: String): Boolean = {
  var checker: Int = 0

  for (i <- 0 until s.length) {
    val value: Int = s.charAt(i) - 'a'
    if ((checker & (1 << value)) > 0) return false
    checker |= (1 << value)
  }
  true
}
 
isUniqueCharsOne("hola")
isUniqueCharsTrue("hola")
isUniqueCharsThree("hola")
