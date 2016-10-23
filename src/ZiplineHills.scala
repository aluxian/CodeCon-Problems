//Problem        : Zipline Hills
//Language       : Scala
//Compiled Using : scalac
//Version        : scalac 2.11.6
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT
import scala.io.Source.stdin

//Your submission should *ONLY* use the following object name
object ZiplineHills extends App {
  val lines = stdin.getLines()
  val N = lines.next().toInt
  val heights = lines.take(N).map(_.toInt).toList

  val maxLength = heights.indices
    .map(steps)
    .map(_.size)
    .max

  println(maxLength - 1)

  def steps(index: Int): Seq[Int] = {
    Seq(-2, -1, 1, 2) // possible moves
      .filter(_ + index < heights.length) // remove out of bound indexes (upper)
      .filter(_ + index >= 0) // remove out of bound indexes (lower)
      .filter(d => heights(index + d) < heights(index)) // remove hills that are of equal or higher height
      .map(d => steps(index + d)) // count steps for each move
      .sortBy(_.size) // sort by size
      .reverse // desc
      .headOption
      .getOrElse(Seq[Int]())
      .+:(index)
  }

}
