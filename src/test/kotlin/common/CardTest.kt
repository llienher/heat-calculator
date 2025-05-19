package common

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CardTest {
    private val player1 = Player(PlayerColor.RED, PlayerType.NPC)
    private val player2 = Player(PlayerColor.BLUE, PlayerType.NPC)
    private val playersList = listOf(player1, player2)
    private val testCard = Card(playersList)


    @Test
    fun `Create an array of all move possibilities`() {
        val excepted: ArrayList<MoveInfo> = arrayListOf(
            MoveInfo(0, 10),
            MoveInfo(0, 11),
            MoveInfo(1, 12),
            MoveInfo(1, 13),
            MoveInfo(1, 14),
            MoveInfo(2, 15),
            MoveInfo(2, 16),
            MoveInfo(2, 17),
            MoveInfo(3, 18),
            MoveInfo(3, 19),
        )
        assertEquals(excepted, testCard.createCombinations())
    }

}