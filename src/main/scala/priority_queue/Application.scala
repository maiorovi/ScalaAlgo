package priority_queue

import graphs.dejkstra.Application.Line

import scala.io.Source

object Application {
  def main(args:Array[String]): Unit = {
    val seq = readFile("median.txt").map(numb => numb.toInt)
    val medianMaintenance = new MedianMaintenance

    println(medianMaintenance.allMediansOfSequence(seq).sum % 10000)
  }

  def readFile(filename:String):List[Line] = Source.fromResource(filename).getLines().toList
}
