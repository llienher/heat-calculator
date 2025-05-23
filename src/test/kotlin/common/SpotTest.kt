package common

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SpotTest {
    private val testPlayer = Player(PlayerColor.RED, PlayerType.NPC)
    private val testSpot = Spot(numSector = 1, SpotType.STRAIGHT, trackIndex = 1, player = testPlayer)

    @Test
    fun isOccupied() {
        val excepted = true
        assertEquals(excepted, testSpot.isOccupied())
    }
}