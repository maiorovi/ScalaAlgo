package priority_queue

class MedianMaintenance {
  val minPQ: HeapBasedMaxPriorityQueue = new HeapBasedMaxPriorityQueue
  val maxPQ: HeapBasedMinPriorityQueue = new HeapBasedMinPriorityQueue


  def balancePqsIfNeeded() = {
    if ((minPQ.size - maxPQ.size) > 1) {
      val max = minPQ.deleteMax()
      maxPQ.insert(max)
    } else if (maxPQ.size - minPQ.size > 1) {
      val min = maxPQ.deleteMin()
      minPQ.insert(min)
    }
  }

  def swapElementsInQueuesIfNeeded() = {
    if (minPQ.maxElem > maxPQ.minElem) {
      val maxInMin = minPQ.deleteMax()
      val minInMax = maxPQ.deleteMin()
      minPQ.insert(minInMax)
      maxPQ.insert(maxInMin)
    }
  }

  def appendAndFindMedian(x:Int):Int = {
    if (minPQ.isEmpty && maxPQ.isEmpty) {
      minPQ.insert(x)
      return x
    }

    if (maxPQ.isEmpty) {
      maxPQ.insert(x)
      swapElementsInQueuesIfNeeded()
      return minPQ.maxElem
    }

    decideInsertionOf(x)
    balancePqsIfNeeded()
    val median = countMedian()

    median
  }

  private def decideInsertionOf(x: Int) = {
    val minInMax = maxPQ.minElem
    val maxInMin = minPQ.maxElem

    if (x > minInMax) {
      maxPQ.insert(x)
    } else {
      minPQ.insert(x)
    }
  }

  private def countMedian(): Int = {
    if (isOddAmount) {
     returnElemFromBiggerQueue
    } else {
      minPQ.maxElem
    }

  }

  private def returnElemFromBiggerQueue:Int = if (maxPQ.size > minPQ.size) maxPQ.minElem else minPQ.maxElem

  private def isOddAmount:Boolean = (minPQ.size + maxPQ.size) % 2 != 0

  def seqSize:Int = minPQ.size + maxPQ.size

  def allMediansOfSequence(xs:List[Int]):List[Int] = xs.map(appendAndFindMedian)
}
