package hash_tables

import scala.collection.mutable

class TwoSum {
  var counter:Double = 0
  var sum = 0

  def findTwoSumAmount(input: List[Long], start: Int, end: Int): Set[(Long, Long)] = {
    val elems = input.toSet
    var i:Long = start
    val result = new mutable.MutableList[(Long, Long)]()

    while(i <= end) {
      elems.takeWhile(elem => {
        val need:Long = i - elem
        if (elems(need) && elem != need) {
          result.+=((elem, need))
          sum += 1
          false
        } else {
          true
        }
      })
      if(counter % (0.001*(end-start)) == 0) {
        println(s"${counter*100 / (end-start)}%, current sum is: ${sum}" )
      }

      i += 1
      counter+=1
    }

    result.toSet
  }
}
