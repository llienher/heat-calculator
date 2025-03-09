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

/* Memo:
spot: A place of the board where only one car can go
space: A tile of the board, composed of two spots (inner and outer spots)
board -> nb spots, nb, sectors
sectors: length, corner_speed, corner_ai_length
game: nb turns, 1 board, gameStats
turns: actions (straight, corners, etc.), nb cars
 */
