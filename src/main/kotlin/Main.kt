import common.BoardManager
import common.Player
import common.PlayerColor
import common.PlayerType

fun main() {
    val players = listOf(
        Player(color = PlayerColor.RED, type = PlayerType.NPC),
        Player(color = PlayerColor.BLUE, type = PlayerType.NPC),
        Player(color = PlayerColor.YELLOW, type = PlayerType.NPC),
        Player(color = PlayerColor.GREEN, type = PlayerType.NPC),
        Player(color = PlayerColor.YELLOW, type = PlayerType.NPC),
        Player(color = PlayerColor.GREY, type = PlayerType.NPC),
    )
    BoardManager(country = "Mexico", laps = 3, players = players)
    println("Done !")
}
