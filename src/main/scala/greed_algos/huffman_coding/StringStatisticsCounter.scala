package greed_algos.huffman_coding

import scala.collection.mutable

class StringStatisticsCounter {

  def countStatistics(input: String): List[Leaf] = {
    val map = mutable.Map[String, Int]()

    val transformedSequence = input
      .map(ch => (ch.toString, 1))
      .groupBy(v => v._1)
      .map(tuple => (tuple._1, tuple._2.map(t => t._2).sum))

    val totalSum = transformedSequence.map(tuple => tuple._2).sum

    transformedSequence.map( tuple => Leaf(tuple._1, tuple._2 * 100 / totalSum )).toList
  }

}
