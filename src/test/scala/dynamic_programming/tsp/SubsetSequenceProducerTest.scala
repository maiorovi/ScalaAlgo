package dynamic_programming.tsp

import org.scalatest.{FunSuite, Matchers}

class SubsetSequenceProducerTest extends FunSuite with Matchers {

  test("produces all subsequence correctly") {
    val producer = new SubsetSequenceProducer(List(1, 2, 3, 4))

    producer.produceAllSubsets should contain only(
      Set[Int](),
      Set(1),
      Set(2),
      Set(3),
      Set(4),
      Set(1, 2),
      Set(1, 3),
      Set(1, 4),
      Set(2, 3),
      Set(2, 4),
      Set(3, 4),
      Set(1, 2, 3),
      Set(1, 3, 4),
      Set(2, 3, 4),
      Set(1, 2, 4),
      Set(1, 2, 3, 4)
    )
  }

  test("produces all subsequence of a size 1") {
    val producer = new SubsetSequenceProducer(List(1, 2, 3, 4))

    producer.produceAllSubsetOfSize(1) should contain only(
      Set(1),
      Set(2),
      Set(3),
      Set(4)
    )
  }

  test("produces all subsequence of a size 2") {
    val producer = new SubsetSequenceProducer(List(1, 2, 3, 4))

    producer.produceAllSubsetOfSize(2) should contain only(
      Set(1,2),
      Set(2,3),
      Set(3,4),
      Set(2,4),
      Set(1,3),
      Set(1,4)
    )
  }

  test("produces all subsequence of a size 2 which contain 1") {
    val producer = new SubsetSequenceProducer(List(1, 2, 3, 4))

    producer.produceAllSbusetOfSizeWhichContainsGivenElement(2, 1) should contain only(
      Set(1,2),
      Set(1,3),
      Set(1,4)
    )
  }
}
