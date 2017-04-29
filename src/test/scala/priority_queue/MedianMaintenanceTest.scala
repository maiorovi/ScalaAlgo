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

  test("other real case") {
    assertResult((2303 + 2793) / 2) {
      medianMaintenance.appendAndFindMedian(6331)
      medianMaintenance.appendAndFindMedian(2793)
      medianMaintenance.appendAndFindMedian(1640)
      medianMaintenance.appendAndFindMedian(9290)
      medianMaintenance.appendAndFindMedian(225)
      medianMaintenance.appendAndFindMedian(625)
      medianMaintenance.appendAndFindMedian(6195)
      medianMaintenance.appendAndFindMedian(2303)
    }
  }
//  6331
//  2793
//  1640
//  9290
//  225
//  625
}
