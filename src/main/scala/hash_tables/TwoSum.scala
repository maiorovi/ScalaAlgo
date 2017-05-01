package hash_tables

import scala.collection.mutable

class TwoSum {

  def findTwoSumAmount(input:List[Int], start:Int, end:Int):List[(Int,Int)] = {
    val elems = input.toSet
    val bannedTuples = mutable.HashSet[(Int, Int)]()

    input flatMap (elem =>{
      val seq = start to end map (numbFromRange => numbFromRange - elem) filter (elems(_)) map (e => (elem, e)) filter(t => t._1 != t._2) filter(!bannedTuples(_))

      seq.foreach(t => bannedTuples.+=((t._2, t._1)))

      seq
    })
  }



  //    input.foreach{ elem =>
  //      (start to end).foreach { numbFromRange =>
  //        val diff = Math.abs(numbFromRange - elem)
  //        if (elems(diff)) {
  //          (elem, diff)::pairsWhichSumAppearsInRange
  //        }
  //      }
  //    }


}
