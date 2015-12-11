import scala.collection.immutable.Queue

object HotPotatoGame {

	def rotate(queue:Queue[String]) = {
		val (player, updatedQueue) = queue.dequeue
		val rotatedQueue = updatedQueue.enqueue(player)
		rotatedQueue
	}

	def rotateTimes(n:Int, queue:Queue[String]) : Queue[String] = {
		var result = queue
		for (x <- 1 to n) {
			result = rotate(result)
		}
		result
	}

	def random(n:Int) : Int = {
		(scala.math.random	* n + 1).toInt
	}

	def hotPotato(players:List[String], n:Int) : String	= {
		var playersQueue = Queue[String]().enqueue(players)
    while(playersQueue.length > 1) {
      playersQueue = rotateTimes(n, playersQueue)
      val (_, updatedQueue) = playersQueue.dequeue
      playersQueue = updatedQueue
    }
		val (winner, _) = playersQueue.dequeue
		winner
	}

	def main(args: Array[String]) {
		val playersList = List("Sam", "Max", "Mike", "Deborah", "John", "Will", "Nick")
		val times = random(playersList.size * 2)
		println("The winner is " + hotPotato(playersList, times))
	}
}

