package tree

import org.scalatest.{BeforeAndAfter, FunSuite}

class TreeTest extends FunSuite with BeforeAndAfter {

  var tree: Tree[Int] = _

  before {
    tree = Node(3, Node(1, Empty, Leaf(2)), Node(5, Leaf(4), Empty))
  }

  test("finds the max in the tree") {
    assertResult(5) {
      Tree.max(tree)
    }
  }

  test("find the min in the tree") {
    assertResult(1) {
      Tree.min(tree)
    }
  }

  test("produces in order traversal") {
    assertResult(List(1,2,3,4, 5)) {
      tree.inOrderTraversal
    }
  }

}
