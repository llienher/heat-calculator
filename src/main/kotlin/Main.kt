import common.BoardManager
import common.Player
import common.PlayerColor
import common.PlayerType

fun main() {
    val players = listOf(
        Player(color = PlayerColor.RED, type = PlayerType.AI),
        Player(color = PlayerColor.BLUE, type = PlayerType.AI),
        Player(color = PlayerColor.YELLOW, type = PlayerType.AI),
        Player(color = PlayerColor.GREEN, type = PlayerType.AI),
        Player(color = PlayerColor.YELLOW, type = PlayerType.AI),
        Player(color = PlayerColor.GREY, type = PlayerType.AI),
    )
    BoardManager(country = "Mexico", laps = 3, players = players)
    println("Done !")
}
