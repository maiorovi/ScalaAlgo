package dynamic_programming.tsp

import scala.collection.mutable
import scala.reflect.ClassTag

class SubsetSequenceProducer[T](val x: List[T])(implicit m: ClassTag[T]) {

  private val sizeToSubsetsMappingCache = produceAllSubsets.groupBy(set => set.size)

  def produceAllSubsets: List[Set[T]] = {
    val container = mutable.MutableList[Set[T]]()
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

      container += tmp.toSet
      i += 1
    }

    container.toList
  }

  def produceAllSubsetOfSize(size: Int): List[Set[T]] = sizeToSubsetsMappingCache(size)

  def produceAllSbusetOfSizeWhichContainsGivenElement(size: Int, includedElem: T): List[Set[T]] =
    produceAllSubsetOfSize(size).filter(set => set(includedElem))
}
