package graphs

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


trait Graph {
  def addVertex(vertexOne: Vertex): Unit

  def addEdge(edge: Edge): Unit

  def vertextAmount: Int

  def edgesAmount: Int

  def adjacent(v: Vertex): List[Edge]
}

class AdjacencyListBasedGraph extends Graph {
  private val adjacencyList: mutable.LinkedHashMap[Vertex, ArrayBuffer[Edge]] = mutable.LinkedHashMap[Vertex, ArrayBuffer[Edge]]()

  override def adjacent(v: Vertex): List[Edge] = ???

  override def vertextAmount: Int = adjacencyList size

  override def edgesAmount: Int = adjacencyList.values.map(buffer => buffer.size).sum

  override def addEdge(edge: Edge): Unit = {
    val (fstVertex, sndVertex) = edge.connectedVertexes

    if (!adjacencyList.contains(fstVertex) || !adjacencyList.contains(sndVertex)) {
      throw new IllegalArgumentException()
    }

    adjacencyList(fstVertex) += edge
    adjacencyList(sndVertex) += edge
  }

  override def addVertex(vertexOne: Vertex): Unit = adjacencyList += (vertexOne -> ArrayBuffer())
}

case class Vertex(id: String)

case class Edge(from: Vertex, to: Vertex) {
  def other(that: Vertex): Vertex = if (from == that) to
  else if (that == to) from
  else throw new IllegalArgumentException("Vertex doesn`t have any relations to this edge")

  def connectedVertexes:(Vertex, Vertex) = (from, to)
}
