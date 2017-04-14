package graphs

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.Fact.Binary_&
import org.scalatest.Matchers._

class DirectedAdjacencyListBasedGraphTest extends FunSuite with BeforeAndAfter {
  var adjacencyBasedListGraph: DirectedAdjacencyBasedListGraph = _

  before {
    adjacencyBasedListGraph = new DirectedAdjacencyBasedListGraph
  }

  test("reverts provided graph") {
    val vertexOne = Vertex("1")
    val vertexTwo = Vertex("2")
    val vertexThree = Vertex("3")
    val vertexFour = Vertex("4")

    val edgeOne = Edge(vertexOne, vertexTwo)
    val edgeTwo = Edge(vertexOne, vertexThree)
    val edgeThree = Edge(vertexTwo, vertexFour)
    val edgeFour = Edge(vertexThree, vertexFour)

    adjacencyBasedListGraph.addVertex(vertexOne, vertexTwo, vertexThree, vertexFour)
    adjacencyBasedListGraph.addEdge(edgeOne, edgeTwo, edgeThree, edgeFour)


    adjacencyBasedListGraph.adjacent(vertexOne) should have size 2

    val reversedGraph = adjacencyBasedListGraph.reverse()

    reversedGraph.adjacent(vertexOne) should have size 0
    reversedGraph.adjacent(vertexFour) should have size 2
  }

}
