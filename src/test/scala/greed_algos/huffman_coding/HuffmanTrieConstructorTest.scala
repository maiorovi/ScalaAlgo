package greed_algos.huffman_coding

import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class HuffmanTrieConstructorTest extends FunSuite with Matchers with BeforeAndAfter {

  var huffmanTrieConstructor: HuffmanTrieConstructor = _

  before {
    huffmanTrieConstructor = new HuffmanTrieConstructor
  }

  test("construct huffmanTrieCorrectly") {
     val leafs = List(Leaf("A", 60), Leaf("B", 25), Leaf("C", 10), Leaf("D", 5))
    val expectedTree = InternalNode(100, Leaf("A", 60), InternalNode(40, Leaf("B", 25), InternalNode(15, Leaf("C", 10), Leaf("D", 5))))

      huffmanTrieConstructor.buildHuffmanCodingTrie(leafs) shouldBe expectedTree
  }
}
