package priority_queue

import org.scalatest.{BeforeAndAfter, FunSuite}

class MaxPriorityQueueTest extends FunSuite with BeforeAndAfter {

  var pq: HeapBasedMaxPriorityQueue = _

  before {
    pq = new HeapBasedMaxPriorityQueue()
  }

  test("determines size of priority queue") {
    assertResult(0) {
      pq.size
    }
  }

  test("size increased by one after each insertion") {
    pq.insert(10)

    assertResult(1) {
      pq.size
    }
  }

  test("correctly inserts data in heap based priority queue") {
    pq.insert(2)
    pq.insert(3)
    pq.insert(4)
    pq.insert(5)
    pq.insert(1)

    assertResult(5) {
      pq.maxElem
    }

  }

  test("deletes max") {
    pq.insert(2)
    pq.insert(3)
    pq.insert(4)
    pq.insert(5)
    pq.insert(1)

    assertResult(5) {
      pq.deleteMax()
    }

    assertResult(4) {
      pq.deleteMax()
    }

    assertResult(3) {
      pq.deleteMax()
    }

    assertResult(2) {
      pq.deleteMax()
    }

    assertResult(1) {
      pq.deleteMax()
    }
  }

  test("delete min on empty queue throws runtime exception") {
    assertThrows[RuntimeException]{
      pq.deleteMax()
    }
  }

}
