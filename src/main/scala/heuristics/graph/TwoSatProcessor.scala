package heuristics.graph

import graphs.{StronglyConnectedComponentsAlgo, Vertex}

class TwoSatProcessor(val twoSatGraphConstructor: TwoSatGraphConstructor,
                      val stronglyConnectedComponentsAlgo: StronglyConnectedComponentsAlgo) {


  def isTractable(lines:List[String]):Boolean = {
    val graph = twoSatGraphConstructor.buildGraph(lines)
    val components = stronglyConnectedComponentsAlgo.findStronglyConnectedComponents(graph)

    for (component <- components; vertex <- component) {
      if (component.contains(new Vertex(-vertex.id.toInt))) {
        return false
      }
    }

    return true
  }


}
