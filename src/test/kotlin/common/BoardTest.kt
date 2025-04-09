package common

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class BoardTest {
    private val testSectorList = List(1) { Sector(1, 3, 2, 1) }
    private val testBoard = Board("test", 1, 4, testSectorList)

    @Test
    fun getTrack() {
    }

    @Test
    fun assignSpots() {
        // Create excepted data
        val spot1 = Spot(numSector = 1, type = SpotType.STRAIGHT, boardPosition = 0)
        val spot2 = Spot(numSector = 1, type = SpotType.STRAIGHT, boardPosition = 1)
        val spot3 = Spot(numSector = 1, type = SpotType.STRAIGHT, boardPosition = 2)
        val spot4 = Spot(numSector = 1, type = SpotType.STRAIGHT, boardPosition = 3)
        val spot5 = Spot(numSector = 1, type = SpotType.LEGEND, boardPosition = 4)
        val spot6 = Spot(numSector = 1, type = SpotType.LEGEND, boardPosition = 5)
        val spot7 = Spot(numSector = 1, type = SpotType.LEGEND, boardPosition = 6)
        val spot8 = Spot(numSector = 1, type = SpotType.LEGEND, boardPosition = 7)
        val exceptedTrack = listOf(spot1, spot2, spot3, spot4, spot5, spot6, spot7, spot8)

        val assignedSpots = testBoard.assignSpots(testSectorList[0], 0)
        assertEquals(exceptedTrack.size, assignedSpots)

        for ((index, spot) in testBoard.getTrack().withIndex()) {
            assertEquals(exceptedTrack[index], spot)
        }
    }

    @Test
    fun setPlayerStartingPosition() {
    }

    @Test
    fun movePlayerOnTrack() {
        // Create excepted data
        val player1 = Player(PlayerColor.RED, PlayerType.AI)
        val player2 = Player(PlayerColor.BLUE, PlayerType.AI)
        val spot1 = Spot(numSector = 1, type = SpotType.STRAIGHT, boardPosition = 0) // space 1 off race line
        val spot2 = Spot(numSector = 1, type = SpotType.STRAIGHT, boardPosition = 1) // space 1 near race line
        val spot3 = Spot(numSector = 1, type = SpotType.STRAIGHT, boardPosition = 2) // space 2 off race line
        val spot4 = Spot(numSector = 1, type = SpotType.STRAIGHT, boardPosition = 3) // space 2 near race line
        val spot5 =
            Spot(numSector = 1, type = SpotType.LEGEND, boardPosition = 4, player = player2) // space 3 off race line
        val spot6 =
            Spot(numSector = 1, type = SpotType.LEGEND, boardPosition = 5, player = player1) // space 3 near race line
        val spot7 = Spot(numSector = 1, type = SpotType.LEGEND, boardPosition = 6) // space 4 off race line
        val spot8 = Spot(numSector = 1, type = SpotType.LEGEND, boardPosition = 7) // space 4 near race line
        val exceptedTrack = listOf(spot1, spot2, spot3, spot4, spot5, spot6, spot7, spot8)

        // Init test
        testBoard.assignSpots(testSectorList[0], 0)
        testBoard.setPlayerStartingPosition(player1, -1)
        testBoard.setPlayerStartingPosition(player2, -2)
        testBoard.movePlayerOnTrack(player1, 3)
        testBoard.movePlayerOnTrack(player2, 3)

        for ((index, spot) in testBoard.getTrack().withIndex()) {
            assertEquals(exceptedTrack[index], spot)
        }
    }
}