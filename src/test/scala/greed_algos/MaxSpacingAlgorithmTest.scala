package greed_algos

import graphs.{AdjacencyListBasedGraph, Edge, Vertex}
import greed_algos.kruskal.MaxSpacingAlgorithm
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class MaxSpacingAlgorithmTest extends FunSuite with BeforeAndAfter with Matchers {

  var maxSpacingAlgorithm: MaxSpacingAlgorithm = _

  before {
    maxSpacingAlgorithm = new MaxSpacingAlgorithm
  }

  test("simple graph to validate correctness") {
    val graph = new AdjacencyListBasedGraph

    val v1 = Vertex("1")
    val v2 = Vertex("2")
    val v3 = Vertex("3")
    val v4 = Vertex("4")
    val v5 = Vertex("5")
    val v6 = Vertex("6")

    val e1 = Edge(v1, v6, 1)
    val e2 = Edge(v4, v5, 2)
    val e3 = Edge(v6, v5, 3)
    val e4 = Edge(v1, v2, 5)
    val e5 = Edge(v4, v3, 4)
    val e6 = Edge(v2, v3, 7)

    graph.addVertex(v1, v2, v3, v4, v5, v6)

    graph.addEdge(e1, e2, e3, e4, e5, e6)

    maxSpacingAlgorithm.runMaxSpacingProblem(graph, 3) shouldBe (4)
  }

}
