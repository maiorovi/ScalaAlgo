package dynamic_programming.tsp

import org.scalatest.{FunSuite, Matchers}

class SubsetSequenceProducerTest extends FunSuite with Matchers {

  test("produces all subsequence correctly") {
   val producer = new SubsetSequenceProducer

    producer.produceAllSubsets(List(1,2,3,4)) should contain only(
      List[Int](),
      List(1),
      List(2),
      List(3),
      List(4),
      List(1,2),
      List(1,3),
      List(1,4),
      List(2,3),
      List(2,4),
      List(3,4),
      List(1,2,3),
      List(1,3,4),
      List(2,3,4),
      List(1,2,4),
      List(1,2,3,4)
    )
  }

}
