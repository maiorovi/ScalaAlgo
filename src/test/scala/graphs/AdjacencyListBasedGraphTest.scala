package graphs

import graphs.Graph
import org.scalatest.{BeforeAndAfter, FunSuite}

class AdjacencyListBasedGraphTest extends FunSuite with BeforeAndAfter {
  var graph: Graph = _

  before{
    graph = initGraph()
  }

  test("throws illegal argument exception if first vertex of edge is not present in graph") {
    val vertexOne = Vertex("1")
    val vertexTwo = Vertex("2")
    val edge = Edge(vertexOne, vertexTwo)

    assertThrows[IllegalArgumentException] {
      graph.addEdge(edge)
    }
  }

  test("allows vertexes addition") {
    val vertexOne = Vertex("1")

    graph.addVertex(vertexOne)

    assertResult(1) {
      graph.vertextAmount
    }


  }

  test("throws illegal argument exception if second vertex of edge is not present in graph") {
    val vertexOne = Vertex("1")
    val vertexTwo = Vertex("2")
    val edge = Edge(vertexOne, vertexTwo)

    graph.addVertex(vertexOne)

    assertThrows[IllegalArgumentException] {
      graph.addEdge(edge)
    }
  }

  test("number of edges are incremented after edges addition") {
    val vertexOne = Vertex("1")
    val vertexTwo = Vertex("2")
    val edge = Edge(vertexOne, vertexTwo)

    graph.addVertex(vertexOne)
    graph.addVertex(vertexTwo)

    graph.addEdge(edge)

    assertResult(2) {
      graph.edgesAmount
    }
  }

  private def initGraph(): Graph = {
    val graph:Graph = new AdjacencyListBasedGraph()

    graph
  }



}
