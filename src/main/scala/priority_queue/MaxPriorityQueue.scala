package priority_queue

import scala.annotation.tailrec

trait MaxPriorityQueue {
  def insert(elem:Double):Unit
  def deleteMax(): Double
  def size:Int
  def maxElem: Double
  def isEmpty: Boolean
}



class HeapBasedMaxPriorityQueue extends MaxPriorityQueue {
  var heap:Array[Double] = new Array[Double](8)
  var pointer = 0

  override def insert(elem: Double): Unit = {
    ensureSize()
    heap(pointer) = elem
    pointer += 1
    val parentInd = (pointer - 2) / 2
    val childInd = pointer - 1

    bubleUp(childInd, parentInd)
  }

  override def deleteMax(): Double = {
  if (heap.isEmpty) {
    throw new RuntimeException("Queue Is Empty")
  }
  val max = heap(0)
  pointer -= 1
  swap(0, pointer)
  bubleDown(1, 2, 0)
  max
}

@tailrec
private def bubleDown(childOneInd: Int, childTwoInd: Int, parentInd: Int): Unit = {
  val fstChildIsPresentAndLessThenParent = (pointer > childOneInd) && (heap(parentInd) < heap(childOneInd))
  val sndChildIsPresentAndLessThenParent = (pointer > childTwoInd) && (heap(parentInd) < heap(childTwoInd))

  if (fstChildIsPresentAndLessThenParent || sndChildIsPresentAndLessThenParent) {
  val indToUse = if (sndChildIsPresentAndLessThenParent) {
  if (heap(childOneInd) < heap(childTwoInd)) childTwoInd else childOneInd
} else {
  childOneInd
}

  swap(indToUse, parentInd)
  bubleDown(indToUse * 2 + 1, indToUse * 2 + 2, indToUse)
}
}

  override def size: Int = pointer

  override def maxElem: Double = if (isEmpty) throw new RuntimeException("maxElem is called on empty queue") else heap(0)

  private def ensureSize(): Unit = {
    if ((heap.size - 1) < pointer) {
      val newSize = heap.size * 2
      val newArray = new Array[Double](newSize)
      (0 to (heap.size - 1)).foreach(ind => newArray(ind) = heap(ind))
      heap = newArray
    }
  }

  @tailrec
  private def bubleUp(childInd: Int, parentInd: Int): Unit = {
    if (heap(childInd) > heap(parentInd)) {
      swap(childInd, parentInd)
      bubleUp(parentInd, (parentInd - 1) / 2)
    }
  }

  private def swap(from: Int, to: Int): Unit = {
    val tmp = heap(from)
    heap(from) = heap(to)
    heap(to) = tmp
  }

  def isEmpty: Boolean = pointer == 0
}
