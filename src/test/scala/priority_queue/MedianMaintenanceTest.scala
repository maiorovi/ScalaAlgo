package priority_queue

import org.scalatest.{BeforeAndAfter, FunSuite}

class MedianMaintenanceTest extends FunSuite with BeforeAndAfter {
  var medianMaintenance: MedianMaintenance = _

  before {
    medianMaintenance =  new MedianMaintenance
  }

  test("median computed for one element is correct") {
    assertResult(10) {
      medianMaintenance.appendAndFindMedian(10)
    }
  }

  test("median computed for two elements is correct") {
    assertResult(10) {
      medianMaintenance.appendAndFindMedian(5)
      medianMaintenance.appendAndFindMedian(15)
    }
  }

  test("median computed for 3 elements is correct") {
    assertResult(5) {
      medianMaintenance.appendAndFindMedian(5)
      medianMaintenance.appendAndFindMedian(15)
      medianMaintenance.appendAndFindMedian(1)
    }
  }

  test("balances collections when all inserts appear in one of them") {
    assertResult(4) {
      medianMaintenance.appendAndFindMedian(5)
      medianMaintenance.appendAndFindMedian(15)
      medianMaintenance.appendAndFindMedian(1)
      medianMaintenance.appendAndFindMedian(3)
    }
  }

  test("case when first elem is bigger then first") {
    assertResult(7) {
      medianMaintenance.appendAndFindMedian(15)
      medianMaintenance.appendAndFindMedian(5)
      medianMaintenance.appendAndFindMedian(1)
      medianMaintenance.appendAndFindMedian(9)
    }
  }

}
