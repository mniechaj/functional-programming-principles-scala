package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  printSet(map(x => x % 2 == 0, x => x + 7))
}
