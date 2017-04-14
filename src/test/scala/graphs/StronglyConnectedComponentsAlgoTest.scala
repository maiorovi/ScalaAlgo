package graphs

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.Matchers._

import scala.collection.mutable

class StronglyConnectedComponentsAlgoTest extends FunSuite with BeforeAndAfter {

  var stronglyConnectedComponentsAlgo: StronglyConnectedComponentsAlgo = _

  before {
    stronglyConnectedComponentsAlgo = new StronglyConnectedComponentsAlgo
  }

  test("computes strongly connected components") {
    val graph = new DirectedAdjacencyBasedListGraph
    val vertexOne = Vertex("1")
    val vertexTwo = Vertex("2")
    val vertexThree = Vertex("3")
    val vertexFour = Vertex("4")
    val vertexFive = Vertex("5")
    val vertexSix = Vertex("6")
    val vertexSeven = Vertex("7")
    val vertexEight = Vertex("8")
    val vertexNine = Vertex("9")

    val edge1 = Edge(vertexOne, vertexFour)
    val edge2 = Edge(vertexFour, vertexSeven)
    val edge3 = Edge(vertexSeven, vertexOne)
    val edge4=  Edge(vertexNine, vertexSeven)
    val edge5 = Edge(vertexNine, vertexThree)
    val edge6 = Edge(vertexThree, vertexSix)
    val edge7 = Edge(vertexSix, vertexNine)
    val edge8 = Edge(vertexEight, vertexSix)
    val edge9 = Edge(vertexEight, vertexFive)
    val edge10 = Edge(vertexFive, vertexTwo)
    val edge11 = Edge(vertexTwo, vertexEight)

    graph.addVertex(vertexOne, vertexTwo, vertexThree, vertexFour, vertexFive, vertexSix, vertexSeven, vertexEight, vertexNine)

    graph.addEdge(edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8, edge9, edge10, edge11)

    val sccs = stronglyConnectedComponentsAlgo.findStronglyConnectedComponents(graph)

    sccs should have size 3
    sccs should contain theSameElementsInOrderAs(mutable.MutableList(
        mutable.Set(vertexFour, vertexSeven, vertexOne),
        mutable.Set(vertexNine, vertexSix, vertexThree),
        mutable.Set(vertexTwo, vertexEight, vertexFive)
    ))
  }
}
