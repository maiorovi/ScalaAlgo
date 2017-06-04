package greed_algos.huffman_coding

import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class HuffmanTableBuilderTest extends FunSuite with Matchers with BeforeAndAfter{

  var huffmanTableBuilder: HuffmanTableBuilder = _

  before {
    huffmanTableBuilder = new HuffmanTableBuilder
  }

  test("construct huffman coding table for given tree") {
    val tree = InternalNode(100, Leaf("A", 60), InternalNode(40, Leaf("B", 25), InternalNode(15, Leaf("C", 10), Leaf("D", 5))))

    val codingTable = huffmanTableBuilder.buildCodingTable(tree)

    codingTable should contain ("A" -> "0", "B" -> "10", "C" -> "110", "D" -> "111")
  }



}
