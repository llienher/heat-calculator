package common

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class CardManagerTest {
    private val player1 = Player(PlayerColor.RED, PlayerType.NPC)
    private val player2 = Player(PlayerColor.BLUE, PlayerType.NPC)
    private val player3 = Player(PlayerColor.YELLOW, PlayerType.NPC)
    private val player4 = Player(PlayerColor.GREEN, PlayerType.NPC)
    private val player5 = Player(PlayerColor.BLACK, PlayerType.NPC)
    private val player6 = Player(PlayerColor.GREY, PlayerType.NPC)
    private val player7 = Player(PlayerColor.ORANGE, PlayerType.NPC)
    private val player8 = Player(PlayerColor.VIOLET, PlayerType.NPC)
    private val playersList = listOf(player1, player2, player3, player4, player5, player6, player7, player8)
    private val testCardManager = CardManager(playersList)


    // @Test
    // fun `Create a quota for 6 or less players`() {
    //     val excepted: ArrayList<Int> = arrayListOf(2,3,3,2)
    //     assertEquals(excepted, testCardManager.zoneQuotas)
    // }

    @Test
    fun `Initialize CardManager correctly`() {
        val curCardPos = testCardManager.possibleCardMoves
        val curPlayersPos = testCardManager.possiblePlayerMoves
        assertEquals(10, curCardPos.size)
        assertEquals(playersList.size, curPlayersPos.size)
    }

    @BeforeTest
    fun beforeTest() {
        testCardManager.resetCardPossibilities()
        testCardManager.resetPlayersPossibilities(playersList)
    }

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
        assertEquals(excepted, testCardManager.createMoveInfoList())
    }

    @Test
    fun `Create a player move`() {
        val color = PlayerColor.RED
        val current = testCardManager.createOnePlayerMove(color)
        val exceptedPossible = testCardManager.possiblePlayerMoves[0].possibleMoveInfo
        assertEquals(9, exceptedPossible.size)
        assert(current.moveInfo !in exceptedPossible)
    }

    @Test
    fun `Create a card`() {
        val current = testCardManager.createOneCard(playersList)
        val exceptedPossible = testCardManager.possibleCardMoves
        assertEquals(2, exceptedPossible.size)
        for (pmi in current.moves) {
            assert(pmi.moveInfo !in exceptedPossible)
        }
    }
}