package greed_algos

import greed_algos.kruskal.HammingDistanceCounter
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class HammingDistanceCounterTest extends FunSuite with BeforeAndAfter with Matchers {

  var hammingDistanceCounter:HammingDistanceCounter = _

  before {
    hammingDistanceCounter = new HammingDistanceCounter
  }


  test("counts hamming distance correctly for two simple strings with equal size") {
    val s1 = "abc"
    val s2 = "cqc"

    hammingDistanceCounter.countHamiltonDistance(s1, s2) shouldBe 2
  }

  test("counts hamming distance correctly for two simple strings with different size") {
    val s1 = "abcasdew"
    val s2 = "cqc"

    hammingDistanceCounter.countHamiltonDistance(s1, s2) shouldBe 7
  }

  test("counts correctly real world example") {
    val s1 = "0 1 1 0 0 1 1 0 0 1 0 1 1 1 1 1 1 0 1 0 1 1 0 1"
    val s2 = "0 1 0 0 0 1 0 0 0 1 0 1 1 1 1 1 1 0 1 0 0 1 0 1"

    hammingDistanceCounter.countHamiltonDistance(s1, s2) shouldBe 3
  }


}
