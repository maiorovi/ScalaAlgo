package graphs.dejkstra

import graphs.{Edge, Vertex}

import scala.collection.mutable.ArrayBuffer

trait Queue[A] {
  def pollMin():A
  def enqueue(b: A): Unit
  def +=(b:A): Unit
  def minElem():A
  def isEmpty:Boolean
  def ++=(pairs: Seq[LookupPair]):Unit
  def size:Int
}

case class LookupPair(val vertex: Vertex, val key:Integer)

class ArrayBufferBasedQueue extends Queue[LookupPair] {
  private val buffer = ArrayBuffer[LookupPair]()

  override def pollMin(): LookupPair =  {
    val min = buffer.reduce((x,y) => if (x.key > y.key) y else x)
    buffer.remove(buffer.indexOf(min))
    min
  }

  override def enqueue(elem: LookupPair): Unit = buffer += elem

  override def +=(b: LookupPair): Unit = enqueue(b)

  override def ++=(pairs: Seq[LookupPair]): Unit = pairs.foreach(enqueue _)

  override def minElem(): LookupPair = ???

  override def isEmpty: Boolean = buffer.size == 0

  override def size: Int = buffer.size
}
