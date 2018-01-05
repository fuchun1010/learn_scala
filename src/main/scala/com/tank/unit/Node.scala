package com.tank.unit

import scala.collection.mutable.ArrayBuffer

class Node(data: Option[String],
           id: String,
           desc: String,
           children: Option[ArrayBuffer[Node]]) {

  def isParent: Boolean = data.isEmpty

  def addChildren(node: Node): Unit = children match {
    case Some(children) => children += node
    case _ => throw new Exception("not parent node")
  }

  def display(): Unit = {

    def disPlay(node: Node): Unit = {
      node.isParent match {
        case false => println(node)
        case _ => ()
      }
    }

    this.children match {
      case Some(arrayBuffer) => {
        println(this)
        arrayBuffer.toArray.foreach(disPlay(_))
      }
      case _ =>
    }

    disPlay(this)
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
    id, desc, Option(new ArrayBuffer[Node]()))

  def apply(data: String,
            id: String,
            desc: String) = new Node(Option(data), id, desc, Option.empty)
}
