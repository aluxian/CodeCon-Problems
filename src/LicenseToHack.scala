//Problem        : License to Hack
//Language       : Scala
//Compiled Using : scalac
//Version        : scalac 2.11.6
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT
import scala.io.Source.stdin

//Your submission should *ONLY* use the following object name
object LicenseToHack extends App {
  val lines = stdin.getLines()
    val message = lines.next()
    val N = lines.next().toInt
//  val message = "This should be easy!"
//  val N = 3

  val groups = splitInto(message, N)
  val decodedGroups = decodeGroups(groups)
  println(decodedGroups.mkString(""))

  def splitInto(str: String, size: Int): Seq[String] = {
    var parts = Seq[String]()
    var i = 0

    while (i <= str.length) {
      parts = parts :+ str.substring(i, Math.min(i + size, str.length))
      i += size
    }

    parts
  }

  def decodeGroups(groups: Seq[String]): Seq[String] = {
    groups.zipWithIndex.map {
      case (str, index) =>
        if (index % 2 == 1) {
          str
        } else {
          str.reverse
        }
    }
  }

}
