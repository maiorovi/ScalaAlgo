package greed_algos.huffman_coding

import scala.collection.mutable

class HuffmanTableBuilder {

    def buildCodingTable(node:Node):Map[String, String] = {
      val map = mutable.HashMap[String, String]()

      def loop(node:Node, codeSoFar:String):Unit = node match {
        case InternalNode(freq, left, right) => loop(left, s"${codeSoFar}0"); loop(right, s"${codeSoFar}1")
        case Leaf(symbol, freq) => map.put(symbol, codeSoFar)
      }

      map.toMap
    }
}
