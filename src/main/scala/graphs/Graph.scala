package graphs

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


trait Graph {
  def addVertex(vertexOne: Vertex): Unit

  def addVertex(vertexes: Vertex*): Unit

  def addEdge(edge: Edge): Unit

  def addEdge(edge: Edge*): Unit

  def vertextAmount: Int

  def edgesAmount: Int

  def adjacent(v: Vertex): List[Vertex]

  def outEdges(v:Vertex):List[Edge]

  def vertecies: List[Vertex]

  def edges: List[Edge]
}

class AdjacencyListBasedGraph extends Graph {
  private val adjacencyList: mutable.LinkedHashMap[Vertex, ArrayBuffer[Edge]] = mutable.LinkedHashMap[Vertex, ArrayBuffer[Edge]]()

  override def adjacent(v: Vertex): List[Vertex] =
    adjacencyList.get(v).map(arrayBuffer => arrayBuffer.map(edge => edge.other(v))).get.to[List]

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

  override def addVertex(vertexOne: Vertex): Unit = {
    if (adjacencyList.contains(vertexOne)) {
      throw new IllegalArgumentException("this vertex is already present in graph")
    }
    adjacencyList += (vertexOne -> ArrayBuffer())
  }

  override def addVertex(vertexOne: Vertex*): Unit = vertexOne.foreach(addVertex _)

  override def addEdge(edge: Edge*): Unit = edge.foreach(addEdge _)

  override def vertecies: List[Vertex] = adjacencyList.keySet.toList

  override def outEdges(v: Vertex): List[Edge] = adjacencyList(v).toList

  def edges: List[Edge] = adjacencyList.keySet.flatMap(v => adjacencyList(v).toSet).toList
}

class DirectedAdjacencyBasedListGraph extends Graph {
  def edgeWeightBetween(v1: Vertex, v2: Vertex): Int = if (hasEdge(v1,v2)) outEdges(v1).filter(e => e.to == v2).head.weight else Integer.MAX_VALUE;

  def hasEdge(v1:Vertex, v2:Vertex): Boolean = outEdges(v1).filter(e => e.to == v2).size > 0

  val adjacencyListBasedGraph = mutable.LinkedHashMap[Vertex, ArrayBuffer[Edge]]()

  override def addVertex(vertexOne: Vertex): Unit = {
    if (adjacencyListBasedGraph.contains(vertexOne)) {
//      throw new IllegalArgumentException("vertex is already present inside graph")
    } else {
      adjacencyListBasedGraph += (vertexOne -> ArrayBuffer[Edge]())
    }

  }

  override def addVertex(vertexes: Vertex*): Unit = vertexes.foreach(vertex => addVertex(vertex))

  override def addEdge(edge: Edge): Unit = {
    val (from, to) = edge.connectedVertexes
    if (!adjacencyListBasedGraph.contains(from) || !adjacencyListBasedGraph.contains(to)) {
      throw new IllegalArgumentException("it is only allowed to put edge while one of its vertecies in not in graph")
    }

    adjacencyListBasedGraph(from) += edge
  }

  override def addEdge(edge: Edge*): Unit = edge.foreach(e => addEdge(e))

  override def vertextAmount: Int = adjacencyListBasedGraph.keySet.size

  override def edgesAmount: Int = adjacencyListBasedGraph.values.map(ab => ab.size).sum

  override def adjacent(v: Vertex): List[Vertex] = {
    if (!adjacencyListBasedGraph.contains(v)) {
      throw new IllegalArgumentException("vertex is not present in graph")
    }

    adjacencyListBasedGraph(v).map(edge => edge.other(v)).to[List]
  }

  def reverse(): Graph = {
    val newGraph = new DirectedAdjacencyBasedListGraph
    adjacencyListBasedGraph.keySet.foreach(newGraph.addVertex(_))

    adjacencyListBasedGraph.values.foreach( edges => edges.foreach(edge => newGraph.addEdge(edge.reverse)))

    newGraph
  }

  override def vertecies: List[Vertex] = adjacencyListBasedGraph.keySet.to[List]

  override def outEdges(v: Vertex): List[Edge] = adjacencyListBasedGraph(v).toList

  override def edges: List[Edge] = ???
}

case class Vertex(id: String) {
  def this(id: Int) {
    this(id.toString)
  }
}