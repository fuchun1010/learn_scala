package com.tank.main

import com.tank.unit.Node

object Main extends App {
  val parentNode = Node("1", "this is parent node")
  val childNode = Node("7900", "2", "this is child node")
  parentNode.addChildren(childNode)
  parentNode.display()
}




