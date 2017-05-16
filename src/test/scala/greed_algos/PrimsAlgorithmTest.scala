package greed_algos

import graphs.{AdjacencyListBasedGraph, Edge, Vertex}
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class PrimsAlgorithmTest extends FunSuite with Matchers with BeforeAndAfter {

  var primsAlgo: PrimsAlgorithm = _


  before {
    primsAlgo = new PrimsAlgorithm
  }


  test("correctly computes minimum spanning tree of a undirected graph") {
    val graph = new AdjacencyListBasedGraph()

    val vertex1 = Vertex("1")
    val vertex2 = Vertex("2")
    val vertex3 = Vertex("3")
    val vertex4 = Vertex("4")

    val edge1 = Edge(vertex1, vertex2, 2)
    val edge2 = Edge(vertex1, vertex4, 4)
    val edge3 = Edge(vertex2, vertex3, 3)
    val edge4 = Edge(vertex3, vertex4, 5)
    val edge5 = Edge(vertex1, vertex3, 6)

    graph.addVertex(vertex1, vertex2, vertex3, vertex4)
    graph.addEdge(edge1, edge2, edge3, edge4, edge5)

    val (sum, mst) = primsAlgo.runPrimAlgorithm(graph, vertex1)

    sum shouldBe(9)
    mst should contain only (edge1, edge3, edge2)
  }



}
