//Problem        : Chemistry 101
//Language       : Scala
//Compiled Using : scalac
//Version        : scalac 2.11.6
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT
import scala.io.Source.stdin

//Your submission should *ONLY* use the following object name
object Problem extends App {
  val lines = stdin.getLines()
  val N = lines.next().toInt
  val pages = lines.take(N)
    .map {
      line =>
        val parts = line.split(' ')
        (parts(0), parts.takeRight(parts.length - 2).toList)
    }
    .toMap

  val trials = lines.next().split(' ')
  val safe = trials.zipWithIndex.forall {
    case (elem, index) =>
      if (!pages.keys.toList.contains(elem)) {
        true
      } else {
        pages(elem).forall(trials.contains)
      }
  }

  if (safe) {
    println("SAFE!")
  } else {
    println("BOOM!")
  }
}
