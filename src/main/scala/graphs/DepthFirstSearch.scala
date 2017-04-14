package graphs

import scala.collection.mutable

class DepthFirstSearch {

  def traverse(graph: Graph, from: Vertex): Unit = {
    val visited = mutable.Set[Vertex]()
    visited += from

    val stack:mutable.ListBuffer[Vertex] =  new mutable.ListBuffer[Vertex]()
    stack.+=:(from)

    while(!stack.isEmpty) {
      val currentVertex = stack.remove(0)
      graph.adjacent(currentVertex).foreach(adjacent => {
        if (!visited(adjacent)) {
          stack.+=:(adjacent)
        }
      })
    }

  }

  def recursiveDfs(graph:Graph, startvertex: Vertex, stack: mutable.MutableList[Vertex], visited: mutable.Set[Vertex]):Unit = {
    visited += startvertex
    graph.adjacent(startvertex).foreach( vertex => {
      if(!visited(vertex)) {
        visited += vertex
        recursiveDfs(graph, vertex, stack, visited)
    }})

    stack += startvertex
  }

  def recursiveDfsReturnVisited(graph:Graph, startvertex: Vertex, visited: mutable.Set[Vertex], seen:mutable.Set[Vertex]):Unit = {
    visited += startvertex
    seen += startvertex
    graph.adjacent(startvertex).foreach( vertex => {
      if(!visited(vertex)) {
        visited += vertex
        seen += vertex
        recursiveDfsReturnVisited(graph, vertex, visited, seen)
      }})
  }
}
