package graphs.dejkstra

import graphs.{DirectedAdjacencyBasedListGraph, Edge, Vertex}
import org.scalatest.{BeforeAndAfter, FunSuite}

class DejkstraAlgorithmTest extends FunSuite with BeforeAndAfter {
  var dejkstraAlgo: DejkstraAlgorithm = _

  before {
    dejkstraAlgo = new DejkstraAlgorithm()
  }

  test("find correct shortest paths from given vertex s to every other vertexes") {
    val graph = new DirectedAdjacencyBasedListGraph()

    val s = Vertex("1")
    val a = Vertex("2")
    val b = Vertex("3")
    val c = Vertex("4")

    val e1 = Edge(s, a, 1)
    val e2 = Edge(s, c, 2)
    val e3 = Edge(a, b, 3)
    val e4 = Edge(c, b, 4)

    graph.addVertex(s, a, b, c)
    graph.addEdge(e1, e2, e3, e4)

    assertResult(
      Map( s -> 0, a -> 1, c -> 2, b -> 4)
    ) {
      dejkstraAlgo.runDejkstraAlgorithm(graph, s)
    }
  }

}
