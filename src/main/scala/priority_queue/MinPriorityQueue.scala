package priority_queue

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

trait MinPriorityQueue {
  def deleteMin(): Int

  def insert(elem: Int): Unit

  def size: Int

  def minElem: Int

  def isEmpty: Boolean
}


class HeapBasedMinPriorityQueue extends MinPriorityQueue {
  private var array: Array[Int] = Array[Int](2)
  private var pointer = 0

  override def deleteMin(): Int = {
    if (array.isEmpty) {
      throw new RuntimeException("Queue Is Empty")
    }
    val min = array(0)
    pointer -= 1
    swap(0, pointer)
    bubleDown(1, 2, 0)
    min
  }

  @tailrec
  private def bubleDown(childOneInd: Int, childTwoInd: Int, parentInd: Int): Unit = {
    val fstChildIsPresentAndLessThenParent = (pointer > childOneInd) && (array(parentInd) > array(childOneInd))
    val sndChildIsPresentAndLessThenParent = (pointer > childTwoInd) && (array(parentInd) > array(childTwoInd))

    if (fstChildIsPresentAndLessThenParent || sndChildIsPresentAndLessThenParent) {
      val indToUse = if (sndChildIsPresentAndLessThenParent) {
        if (array(childOneInd) > array(childTwoInd)) childTwoInd else childOneInd
      } else {
        childOneInd
      }

      swap(indToUse, parentInd)
      bubleDown(indToUse * 2 + 1, indToUse * 2 + 2, indToUse)
    }
  }

  override def insert(elem: Int): Unit = {
    ensureSize()
    array(pointer) = elem
    pointer += 1
    val parentInd = (pointer - 2) / 2
    val childInd = pointer - 1

    bubleUp(childInd, parentInd)
  }

  private def ensureSize(): Unit = {
    if ((array.size - 1) < pointer) {
      val newSize = array.size * 2
      val newArray = new Array[Int](newSize)
      (0 to (array.size - 1)).foreach(ind => newArray(ind) = array(ind))
      array = newArray
    }
  }

  @tailrec
  private def bubleUp(childInd: Int, parentInd: Int): Unit = {
    if (array(childInd) < array(parentInd)) {
      swap(childInd, parentInd)
      bubleUp(parentInd, (parentInd - 1) / 2)
    }
  }

  private def swap(from: Int, to: Int): Unit = {
    val tmp = array(from)
    array(from) = array(to)
    array(to) = tmp
  }

  override def size: Int = pointer

  override def minElem: Int = if(isEmpty) throw new RuntimeException("minElem is called on Empty Queue") else array(0)

  override def isEmpty: Boolean = pointer == 0
}
