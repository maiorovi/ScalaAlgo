package priority_queue

import graphs.dejkstra.Application.Line

import scala.io.Source

object Application {
  def main(args:Array[String]): Unit = {
    val seq = readFile("median.txt").map(numb => numb.toInt)
    val medianMaintenance = new MedianMaintenance
    val mediansOfHeapBasedAlgorithm = medianMaintenance.allMediansOfSequence(seq)

    println(mediansOfHeapBasedAlgorithm)
    println(mediansOfHeapBasedAlgorithm.sum)
    println(mediansOfHeapBasedAlgorithm.sum % (medianMaintenance.seqSize))
  }

  def readFile(filename:String):List[Line] = Source.fromResource(filename).getLines().toList
}