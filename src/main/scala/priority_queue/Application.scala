package priority_queue

import graphs.dejkstra.Application.Line

import scala.io.Source

object Application {
  def main(args:Array[String]): Unit = {
    val seq = readFile("median.txt").map(numb => numb.toDouble)
    val medianMaintenance = new MedianMaintenance


//    val sortedSeq =seq.sortWith(_ < _)
//    println((sortedSeq(10000/2)))

    println(s"Amount of medians: ${seq.size}" )
    println(medianMaintenance.allMediansOfSequence(seq))
    println(medianMaintenance.allMediansOfSequence(seq).sum % 10000)
  }

  def readFile(filename:String):List[Line] = Source.fromResource(filename).getLines().toList
}
