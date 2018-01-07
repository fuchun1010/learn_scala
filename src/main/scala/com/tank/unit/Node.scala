package com.tank.unit

import scala.collection.mutable.ListBuffer

case class Node[T](data: Option[T],
                   id: String,
                   desc: String,
                   children: Option[ListBuffer[Node[T]]]) {

  def isParent: Boolean = data.isEmpty

  def addChildren(node: Node[T]): Unit = children match {
    case Some(children) => children += node
    case _ => throw new Exception("not parent node")
  }

  def display(): Unit = {

    def display(list: List[Node[T]]): Unit = {
      list match {
        case h :: t => {
          println(h.toString)
          if (h.isParent) {
            h.children match {
              case Some(nodes) => display(nodes.toList)
              case _ => ()
            }
          }
          display(t)
        }
        case _ => ()
      }

    }

    println(this.toString)
    this.children match {
      case Some(nodes) => display(nodes.toList)
      case _ =>
    }
  }

  def find(id: String): Node[T] = {

    def find(nodes: List[Node[T]], id: String): Node[T] = {
      nodes match {
        case h :: t => {
          if (h.id.equals(id)) {
            h
          }
          else {
            val rs = find(t, id)
            if (rs != null) rs else null
          }
        }
        case Nil => null
      }
    }

    if (this.id.equals(id)) {
      this
    }
    else {
      val list = this.children.getOrElse(new ListBuffer[Node[T]]).toList
      find(list, id)
    }

  }

  override def toString: String = {
    val sb = new StringBuilder
    if (this.isParent) {
      sb.append("parent node:")
      sb.append(" id:")
      sb.append(id)
    }
    else {
      sb.append("child node:")
      sb.append(" id:")
      sb.append(id)
      sb.append(" data:")
      sb.append(data.getOrElse(""))
    }
    return sb.toString;
  }
}

object Node {
  def apply[T](id: String, desc: String) = new Node(Option.empty,
    id, desc, Option(ListBuffer[Node[T]]()))

  def apply[T](data: T,
               id: String,
               desc: String) = new Node(Option(data), id, desc, Option.empty)
}
