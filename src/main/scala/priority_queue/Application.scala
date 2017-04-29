package priority_queue

import graphs.dejkstra.Application.Line

import scala.io.Source

object Application {
  def main(args:Array[String]): Unit = {
    val seq = readFile("median.txt").map(numb => numb.toInt)
    val medianMaintenance = new MedianMaintenance
    val medians = medianMaintenance.allMediansOfSequence(seq)

//    val sortedSeq =seq.sortWith(_ < _)
//    println((sortedSeq(10000/2)))

    println(s"Amount of medians: ${seq.size}" )
    println(medians)
    println(medians.sum % 10000)
  }

  def readFile(filename:String):List[Line] = Source.fromResource(filename).getLines().toList
}
