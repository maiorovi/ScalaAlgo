package hash_tables

import org.scalatest.{BeforeAndAfter, FunSuite}

class TwoSumTest extends FunSuite with BeforeAndAfter {

  var twoSum: TwoSum = _

  before {
    twoSum = new TwoSum
  }

  test("works correctly with positive range") {
    assertResult(List((1,2), (1,7), (2,7))) {
      twoSum.findTwoSumAmount(List(1, 2, 10, 12, 13, 14, 7), 0, 10)
    }
  }

}
