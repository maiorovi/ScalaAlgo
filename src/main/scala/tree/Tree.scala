package tree

trait Tree[+A] {
  def inOrderTraversal:List[A] = {
    def loop(tree:Tree[A], acc:List[A]):List[A] = tree match {
      case Node(value, left, right) => (loop(left, acc):+value) ++ loop(right,acc)
      case Leaf(value) => value::acc
      case Empty => acc
    }

    loop(this, Nil)
  }
}

case class Node[A](value: A, left:Tree[A], right:Tree[A]) extends Tree[A]
case class Leaf[A](value:A) extends Tree[A]
case object Empty extends Tree[Nothing]

object Tree {
  def max(tree:Tree[Int]):Int = tree match {
    case Node(value, left, right) => value.max(Math.max(max(left), max(right)))
    case Leaf(value) => value
    case Empty => Int.MinValue
  }

  def min(tree:Tree[Int]):Int = tree match {
    case Node(value, left, right) => value.min(Math.min(min(left), min(right)))
    case Leaf(value) => value
    case Empty => Int.MaxValue
  }

  def contains(tree:Tree[Int], x:Int):Boolean = tree match {
    case Node(value, left, right) => if (value == x) true else contains(left,x) || contains(right, x)
    case Leaf(value) => if (value == x) true else false
    case Empty => false
  }

}



