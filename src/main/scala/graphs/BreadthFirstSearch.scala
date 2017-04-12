package graphs

import java.util

import scala.collection.mutable

class BreadthFirstSearch {

  def traverseAndReturnVisited(graph: Graph, from: Vertex): Set[Vertex] = {
    val visited = mutable.Set[Vertex]()
    visited += from
    val queue: util.LinkedList[Vertex] = new util.LinkedList[Vertex]()
    queue.add(from)

    while (!queue.isEmpty) {
      val currentVertex = queue.poll()

      graph.adjacent(currentVertex).foreach(adjVertex => {
        if (!visited(adjVertex)) {
          visited += adjVertex
          queue.addLast(_)
        }
      })
    }

    visited.toSet
  }

}
