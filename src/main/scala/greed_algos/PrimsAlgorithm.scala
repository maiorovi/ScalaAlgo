package greed_algos

import java.util

import graphs.{Edge, Graph, Vertex}

import scala.collection.mutable

class PrimsAlgorithm {
  private var visited: mutable.Set[Vertex] = _
  private var edgesQueue: mutable.MutableList[Edge] = _
  private var mst:mutable.MutableList[Edge] = _
  private var edgesProcessed = 0

  def runPrimAlgorithm(graph: Graph, startVertex: Vertex): (Int, List[Edge]) = {
    visited = mutable.Set[Vertex]()
    edgesQueue = mutable.MutableList[Edge]()
    mst = mutable.MutableList[Edge]()
    edgesProcessed = 0

    visit(graph, startVertex)

    while(!edgesQueue.isEmpty) {
      val minEdge = findMinEdge(edgesQueue)
      edgesProcessed += 1
      edgesQueue = edgesQueue.filter(e => e != minEdge)

      val to = minEdge.to
      val from = minEdge.from

      if (!(visited(to) && visited(from))) {
        mst += minEdge
        if(!visited(to)) visit(graph, to)
        if(!visited(from)) visit(graph, from)
      }

    }

    println(s"Processed edges ${edgesProcessed}")

    (mst.map(e => e.weight).sum, mst.toList)
  }

  private def visit(graph: Graph, vertex: Vertex): Unit = {
    val outEdges = graph.outEdges(vertex)
    visited += vertex

    outEdges.foreach(edge => {
      if (!visited(edge.other(vertex))) {
        edgesQueue += edge
      }
    })

  }

  private def findMinEdge(collection: mutable.MutableList[Edge]): Edge = {
    collection.foldLeft(collection.head)((acc, e) => if (acc.weight > e.weight) e else acc)
  }

}
