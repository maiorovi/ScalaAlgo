package graphs

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.Matchers._

class TopologicalSortAlgoTest extends FunSuite with BeforeAndAfter {
  var topologicalSortAlgo:TopologicalSortAlgo = _

  before {
    topologicalSortAlgo = new TopologicalSortAlgo()
  }

  test("retunr topological order for a graph") {
    val graph = new DirectedAdjacencyBasedListGraph

    val vertexOne = Vertex("1")
    val vertexTwo = Vertex("2")
    val vertexThree = Vertex("3")
    val vertexFour = Vertex("4")

    val edgeOne = Edge(vertexOne, vertexTwo)
    val edgeTwo = Edge(vertexOne, vertexThree)
    val edgeThree = Edge(vertexTwo, vertexFour)
    val edgeFour = Edge(vertexThree, vertexFour)


    graph.addVertex(vertexOne, vertexTwo, vertexThree, vertexFour)
    graph.addEdge(edgeOne, edgeTwo, edgeThree, edgeFour)

    val sortedVertexes:List[Vertex] = topologicalSortAlgo.sortTopologicaly(graph)

    sortedVertexes should have size 4
    sortedVertexes should contain inOrderOnly (vertexFour, vertexTwo, vertexThree, vertexOne)
  }
}
