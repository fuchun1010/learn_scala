package com.tank.unit

import scala.collection.mutable.ListBuffer

case class Node(data: Option[String],
                id: String,
                desc: String,
                children: Option[ListBuffer[Node]]) {

  def isParent: Boolean = data.isEmpty

  def addChildren(node: Node): Unit = children match {
    case Some(children) => children += node
    case _ => throw new Exception("not parent node")
  }

  def display(): Unit = {
  }

  def find(id: String): Node = {

    def find(nodes: List[Node], id: String): Node = {
      nodes match {
        case h :: t => {
          if (h.id.equals(id)) {
            h
          }
          else {
            val rs = find(t, id)
            if(rs != null) rs else null
          }
        }
        case _ => null
      }
    }
    if(this.id.equals(id)) {
      this
    }
    else {
      val  list =this.children.getOrElse(new ListBuffer[Node]).toList
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
  def apply(id: String, desc: String) = new Node(Option.empty,
    id, desc, Option(ListBuffer[Node]()))

  def apply(data: String,
            id: String,
            desc: String) = new Node(Option(data), id, desc, Option.empty)
}
