//Problem        : Anagram Count
//Language       : Scala
//Compiled Using : scalac
//Version        : scalac 2.11.6
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT
import scala.io.Source.stdin

//Your submission should *ONLY* use the following object name
object AnagramCount extends App {
  val lines = stdin.getLines()
  val N = lines.next().toInt
  val words = lines.take(N)
  val wordCounts = words.map(_.toLowerCase())
    .map {
      word =>
        (word, word.toCharArray
          .map(c => (c, 1))
          .groupBy(_._1)
          .map(g => (g._1, g._2.length))
          )
    }
    .toMap

  val largestAnagramSize = wordCounts
    .map {
      case (_, counts) =>
        wordCounts.filter(_._2.equals(counts)).keys.toSet
    }
    .toSet[Set[String]]
    .toList
    .filter(_.size > 1)
    .map(_.size)
    .sum

  println(largestAnagramSize)
}
