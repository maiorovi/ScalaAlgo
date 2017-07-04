package dynamic_programming.tsp

import scala.collection.mutable
import scala.reflect.ClassTag

class SubsetSequenceProducer {

  def produceAllSubsets[T](x: List[T])(implicit m: ClassTag[T]): List[List[T]] = {
    val container = mutable.MutableList[List[T]]()
    val cardinality = Math.pow(2, x size)
    val array = x.toArray

    var i = 0

    while (i < cardinality) {
      // need better collection
      val tmp = mutable.ListBuffer[T]()
      val binaryRepr = i.toBinaryString.reverse
      (0 until binaryRepr.length).foreach(j => {
        if (binaryRepr.charAt(j) == '1') tmp += array(j)
      })

      container += tmp.toList
      i += 1
    }

    container.toList
  }
}
