package hash_tables

import graphs.dejkstra.Application.Line

import scala.io.Source

object Application {
  type Line = String

  def main(args:Array[String]):Unit = {
    val seq = readFile("prob-2sum.txt").map(BigDecimal(_))
    val twoSum = new TwoSum

    println(twoSum.findTwoSumAmount(seq, -10000, 10000))

  }

  def readFile(filename:String):List[Line] = Source.fromResource(filename).getLines().toList
}
