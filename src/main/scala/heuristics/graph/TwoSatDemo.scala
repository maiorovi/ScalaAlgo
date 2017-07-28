package heuristics.graph

import graphs.StronglyConnectedComponentsAlgo
import hash_tables.Application.Line

import scala.io.Source

object TwoSatDemo {

  def main(args: Array[String]): Unit = {
    val filenamesList = List("2sat/2sat1.txt", "2sat/2sat2.txt", "2sat/2sat3.txt", "2sat/2sat4.txt", "2sat/2sat5.txt", "2sat/2sat6.txt")

    def readFile(filename: String): List[Line] = Source.fromResource(filename).getLines().toList

    val processor = new TwoSatProcessor(
      new TwoSatGraphConstructor, new StronglyConnectedComponentsAlgo
    )

    //    val answer = processor.isTractable(readFile("2sat/2sat2.txt"))

    val answer = (for (file <- filenamesList)
      yield processor.isTractable(readFile(file))).map(result => if (result) 1 else 0)
//    10110
    println(answer.mkString(""))
  }

}
