package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      def inputIsCorrect(): Boolean = c <= r
      def loop(acc: List[Int]): Int = {
        def inSelectedRow(): Boolean = acc.size == r + 1
        def computeOutput(): Int = acc(c)
        def computeNewRow(): List[Int] = if (acc.size.equals(1)) List(1, 1) else 1 +: acc.sliding(2).map{case List(x, y) => x + y}.toList :+ 1
          if (inputIsCorrect()) {
            if (inSelectedRow()) {
              computeOutput()
            } else {
              val newRow = computeNewRow()
              loop(newRow)
            }
          } else
            0
      }

      loop(List(1))
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(acc: Int, leftOvers: List[Char]): Boolean = {
        if (acc >= 0)
          leftOvers match {
            case head :: tail => head match {
              case ('(') => loop(acc + 1, tail)
              case (')') => loop(acc - 1, tail)
              case _ => loop(acc, tail)
            }
            case _ => acc == 0
          }
        else false
      }
      loop(0, chars)
    }

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

      def loop(leftoverMoney: Int, leftoverCoins: List[Int]): Int = {
        if (leftoverMoney > 0) {
          if (leftoverCoins.nonEmpty) {
            loop(leftoverMoney - leftoverCoins.head, leftoverCoins) + loop(leftoverMoney, leftoverCoins.tail)
          } else 0
        }
        else if (leftoverMoney == 0) 1
        else 0
      }
      loop(money, coins)
    }
  }
