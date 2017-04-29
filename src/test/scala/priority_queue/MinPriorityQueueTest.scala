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

  test("addition of a lot of elements causes extension of a heap") {
    1 to 20  foreach pq.insert

    assertResult(1) {
      pq.deleteMin()
    }
  }

  test("isEmpty operation returns true when no elements inserted") {
    assertResult(true) {
      pq.isEmpty
    }
  }

  test("isEmpty operation returns false when at least one element inserted") {
    pq.insert(50)
    assertResult(false) {
      pq.isEmpty
    }
  }

  test("isEmpty returns true when element was inserted and then deleted") {
    pq.insert(50)
    pq.deleteMin()

    assertResult(true) {
      pq.isEmpty
    }
  }

  test("minElem throws runtime exception when called on empty priority queue") {
    assertThrows[RuntimeException] {
      pq.minElem
    }
  }

}
