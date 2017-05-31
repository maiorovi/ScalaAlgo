package greed_algos

import greed_algos.kruskal.AllLessThenThreeHammingDistanceBitStringGenerator
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class AllLessThenThreeHammingDistanceBitStringGeneratorTest extends FunSuite with BeforeAndAfter with Matchers {

  var allLessThenThreeHammingDistanceBitStringGenerator: AllLessThenThreeHammingDistanceBitStringGenerator = _

  before {
    allLessThenThreeHammingDistanceBitStringGenerator = new AllLessThenThreeHammingDistanceBitStringGenerator(5)
  }

  test("correctly generates all variants for 5 bit string") {
    allLessThenThreeHammingDistanceBitStringGenerator.generateAllBitStrings("00000") should contain only (
      "11000",
      "10100",
      "10010",
      "10001",
      "01001",
      "00110",
      "00101",
      "00011",
      "10000",
      "01000",
      "00100",
      "00010",
      "00001",
      "01100",
      "01010"
    )
  }

}
