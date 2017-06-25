package dynamic_programming.floyd_warshall

import graphs.{DirectedAdjacencyBasedListGraph, Edge, Vertex}
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class FloydWarshallBasedAllToAllPathFinderTest extends FunSuite with BeforeAndAfter with Matchers {

  var floydWarshallBasedAllToAllPathFinder: FloydWarshallBasedAllToAllPathFinder = _
  private val INF = 999999

  before {
    floydWarshallBasedAllToAllPathFinder = new FloydWarshallBasedAllToAllPathFinder
  }

  test("floydWarshall algorithm produce all to all shortest path") {
    val v1 = Vertex("1")
    val v2 = Vertex("2")
    val v3 = Vertex("3")
    val v4 = Vertex("4")

    val edge1 = Edge(v1, v2, 5)
    val edge2 = Edge(v1, v4, 10)
    val edge3 = Edge(v2, v3, 3)
    val edge4 = Edge(v3, v4, 1)

    val graph = new DirectedAdjacencyBasedListGraph
    graph.addVertex(v1, v2, v3, v4)

    graph.addEdge(edge1, edge2, edge3, edge4)

    val result = floydWarshallBasedAllToAllPathFinder.findAllToAllPaths(graph)

    result shouldBe (Map(
      (1, 2) -> 5,
      (1,3) -> 8,
      (1,4) -> 9,
      (1, 1) -> 0,
      (2, 1) -> INF,
      (2,3) -> 3,
      (2,4) -> 4,
      (2,2) -> 0,
      (3,1) -> INF,
      (3,2) -> INF,
      (3,3) -> 0,
      (3,4) -> 1,
      (4,4) -> 0,
      (4,1) -> INF,
      (4,2) -> INF,
      (4,3) -> INF
    ))
  }

}
