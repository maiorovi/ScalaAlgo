package greed_algos.huffman_coding

import scala.collection.mutable

class HuffmanTrieConstructor {
  def buildHuffmanCodingTrie(list:List[Node]):Node = {
    def priorityOrdering(leaf: Node):Int = -leaf.freq
    val pq = new mutable.PriorityQueue[Node]()(Ordering.by(priorityOrdering))

    list.foreach(pq += _)
    while (pq.size > 1) {
      val fst = pq.dequeue()
      val snd = pq.dequeue()
      val intNode = InternalNode(fst.freq + snd.freq, snd, fst)
      pq += intNode
    }


    pq.dequeue()
  }
}

trait Node {
  val freq: Int
}
case class InternalNode(override val freq:Int, val lnode:Node, rnode:Node) extends Node
case class Leaf(val symbol:String, override val freq: Int) extends Node

