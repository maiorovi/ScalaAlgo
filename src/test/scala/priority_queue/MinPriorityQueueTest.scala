package priority_queue

import org.scalatest.{BeforeAndAfter, FunSuite}

class MinPriorityQueueTest extends FunSuite with BeforeAndAfter {

  var pq: MinPriorityQueue = _

  before {
    pq = new HeapBasedMinPriorityQueue()
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

    assertResult(1) {
      pq.minElem
    }

  }

  test("deletes min") {
    pq.insert(2)
    pq.insert(3)
    pq.insert(4)
    pq.insert(5)
    pq.insert(1)

    assertResult(1) {
      pq.deleteMin()
    }

    assertResult(2) {
      pq.deleteMin()
    }

    assertResult(3) {
      pq.deleteMin()
    }

    assertResult(4) {
      pq.deleteMin()
    }

    assertResult(5) {
      pq.deleteMin()
    }
  }

  test("delete min on empty queue throws runtime exception") {
    assertThrows[RuntimeException]{
      pq.deleteMin()
    }
  }



}
