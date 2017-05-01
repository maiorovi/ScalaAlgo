package hash_tables

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.Matchers._

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

  test("works with duplicate numbers in array") {
    assertResult(List((1,2), (1,7), (1,2), (1,7), (2,7))) {
      twoSum.findTwoSumAmount(List(1, 1, 2, 10, 12, 13, 14, 7), 0, 10)
    }
  }

  test("works with negative numbers correctly") {
    assertResult(List((1,2), (-10, 12), (-10,13), (-10,14))) {
      twoSum.findTwoSumAmount(List(1, 2, -10, 12, 13, 14), 0, 10)
    }
  }

  test("works with negative range correctly") {
    assertResult(List((1, -10), (1,2), (2, -10),  (-10, 12), (-10,13), (-10,14))) {
      twoSum.findTwoSumAmount(List(1, 2, -10, 12, 13, 14), -10, 10)
    }
  }

  test("bottom range is included into consideration") {
    assertResult(List((5,-5))) {
      twoSum.findTwoSumAmount(List(5, -5), 0, 10)
    }
  }

  test("up range is included into consideration") {
    assertResult(List((6,4))) {
      twoSum.findTwoSumAmount(List(6, 4), 0, 10)
    }
  }

}
