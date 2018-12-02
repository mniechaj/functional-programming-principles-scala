package patmat

import patmat.Huffman._
import patmat._

/**
  * Created by maciek on 20.08.17.
  */

object Main extends App{
  override def main(args: Array[String]): Unit = {
    // println(Huffman.decodedSecret)
    val codeTree: CodeTree = Fork(Leaf('a', 2), Fork(Leaf('k', 1), Fork(Leaf('s', 1), Leaf('i', 1), List('s', 'i'), 2), List('k', 's', 'i'), 3), List('k', 'a', 's', 'i'), 6)
    val message: List[Bit] = List(0, 1, 1, 0, 1, 1, 1, 0)
    val decode = Huffman.decode(codeTree, message)
    println(decode)
    println(Huffman.decodedSecret)
    println(Huffman.encode(codeTree)(List('k', 'a',  's',  'i', 'a')))

    val codeList: CodeTable = List(('a', List(1, 0, 1)), ('b', List(1, 1)), ('c', List(0)))
    println(Huffman.codeBits(codeList)('a'))
    println(Huffman.convert(codeTree))
    println(Huffman.quickEncode(codeTree)(List('k', 'a', 's', 'i', 'a')))
  }
}
