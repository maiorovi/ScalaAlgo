package graphs

import graphs.Graph
import org.scalatest.Matchers._
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

  test("returns adjacent vertecies to given vertex") {
    val vertexOne = Vertex("1")
    val vertexTwo = Vertex("2")
    val vertexThree = Vertex("3")
    val vertexFour = Vertex("4")

    val edge = Edge(vertexOne, vertexTwo)
    val edgeOne = Edge(vertexOne, vertexThree)
    val edgeTwo = Edge(vertexOne, vertexFour)

    graph.addVertex(vertexOne, vertexTwo, vertexThree, vertexFour)
    graph.addEdge(edge, edgeOne, edgeTwo)

    val adjacent:List[Vertex] = graph.adjacent(vertexOne)

    adjacent should have size 3
    adjacent should contain only (vertexTwo, vertexThree, vertexFour)
  }

  test("throws illegal argument exception on attempt to add vertex which is already present in graph") {
    val vertexOne = Vertex("1")

    assertThrows[IllegalArgumentException]{
      graph.addVertex(vertexOne)
      graph.addVertex(vertexOne)
    }
  }

  private def initGraph(): Graph = {
    val graph:Graph = new AdjacencyListBasedGraph()

    graph
  }



}
