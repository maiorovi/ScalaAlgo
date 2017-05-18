package greed_algos

import java.util

import graphs.{Edge, Graph, Vertex}
import priority_queue.HeapBasedMinPriorityQueue

import scala.collection.mutable

class PrimsAlgorithm {

  def runPrimAlgorithm(graph: Graph, startVertex: Vertex): (Int, List[Edge]) = {
    var heap = new mutable.MutableList[Edge]()
    val mst = new mutable.HashSet[Edge]()
    val queue = mutable.Queue[Vertex]()
    val seenVertexes = new mutable.HashSet[Vertex]()

    queue enqueue startVertex

    while(!queue.isEmpty && mst.size != (graph.vertextAmount - 1)) {
      val curVertex = queue.dequeue()
      if (!seenVertexes(curVertex)) {
        seenVertexes += curVertex
        graph.outEdges(curVertex).filter(edge => !seenVertexes(edge.from) || !seenVertexes(edge.to)).foreach(heap += _)


        var minEdge = findMinEdge(heap)
        heap = heap.filter(_ != minEdge)
        //some edges in the priority queue can become not crossing
        while(seenVertexes(minEdge.from) && seenVertexes(minEdge.to)) {
          minEdge = findMinEdge(heap)
          heap = heap.filter(_ != minEdge)
        }

//        heap = heap.filter(_ != minEdge)
        mst += minEdge
        if (!seenVertexes(minEdge.to)) queue enqueue minEdge.to else queue.enqueue(minEdge.from)
      }
    }

    (mst.map(_.weight).sum, mst.toList)
  }

  private def findMinEdge(collection: mutable.MutableList[Edge]):Edge =
    collection.foldLeft(collection.head)((acc, e) => if (acc.weight > e.weight) e else acc)

}
