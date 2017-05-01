package hash_tables

import scala.collection.mutable

class TwoSum {
  var counter = 0
  var sum = 0

  def findTwoSumAmount(input: List[Long], start: Int, end: Int): Set[(Long, Long)] = {
    val elems = input.toSet
    val bannedTuples = mutable.HashSet[(Long, Long)]()

    input flatMap (elem => {
      val seq = (start to end) map (numbFromRange => numbFromRange - elem) filter (elems(_)) map (e => (elem, e)) filter (t => t._1 != t._2) filter (!bannedTuples(_))

      seq.foreach(t => bannedTuples.+=((t._2, t._1)))
      counter += 1

      if (counter % 10000 == 0) {
        println(s"${counter * 100 / 1000000}% completed, current sum: ${sum}")
      }

      if (!seq.isEmpty) {
        println(seq)
      }
      sum += seq.size

      seq

    }) toSet
  }
}
