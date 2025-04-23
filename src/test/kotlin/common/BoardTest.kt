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
        val spot1 = Spot(numSector = 1, type = SpotType.STRAIGHT, trackIndex = 0, boardLabel = 3)
        val spot2 = Spot(numSector = 1, type = SpotType.STRAIGHT, trackIndex = 1, boardLabel = 3)
        val spot3 = Spot(numSector = 1, type = SpotType.STRAIGHT, trackIndex = 2, boardLabel = 2)
        val spot4 = Spot(numSector = 1, type = SpotType.STRAIGHT, trackIndex = 3, boardLabel = 2)
        val spot5 = Spot(numSector = 1, type = SpotType.LEGEND, trackIndex = 4, boardLabel = 1)
        val spot6 = Spot(numSector = 1, type = SpotType.LEGEND, trackIndex = 5, boardLabel = 1)
        val spot7 = Spot(numSector = 1, type = SpotType.LEGEND, trackIndex = 6, boardLabel = 0)
        val spot8 = Spot(numSector = 1, type = SpotType.LEGEND, trackIndex = 7, boardLabel = 0)
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
    fun `Move User players on track with occupied slots for following moves`() {
        // Create excepted data
        val player1 = Player(PlayerColor.RED, PlayerType.USER)
        val player2 = Player(PlayerColor.BLUE, PlayerType.USER)
        val spot1 =
            Spot(numSector = 1, type = SpotType.STRAIGHT, trackIndex = 0, boardLabel = 3) // space 1 off race line
        val spot2 =
            Spot(numSector = 1, type = SpotType.STRAIGHT, trackIndex = 1, boardLabel = 3) // space 1 near race line
        val spot3 =
            Spot(numSector = 1, type = SpotType.STRAIGHT, trackIndex = 2, boardLabel = 2) // space 2 off race line
        val spot4 =
            Spot(numSector = 1, type = SpotType.STRAIGHT, trackIndex = 3, boardLabel = 2) // space 2 near race line
        val spot5 =
            Spot(
                numSector = 1,
                type = SpotType.LEGEND,
                trackIndex = 4,
                boardLabel = 1,
                player = player2
            ) // space 3 off race line
        val spot6 =
            Spot(
                numSector = 1,
                type = SpotType.LEGEND,
                trackIndex = 5,
                boardLabel = 1,
                player = player1
            ) // space 3 near race line
        val spot7 =
            Spot(numSector = 1, type = SpotType.LEGEND, trackIndex = 6, boardLabel = 0) // space 4 off race line
        val spot8 =
            Spot(numSector = 1, type = SpotType.LEGEND, trackIndex = 7, boardLabel = 0) // space 4 near race line
        val exceptedTrack = listOf(spot1, spot2, spot3, spot4, spot5, spot6, spot7, spot8)

        // Init test
        testBoard.assignSpots(testSectorList[0], 0)
        testBoard.setPlayerStartingPosition(player1, -1)
        testBoard.setPlayerStartingPosition(player2, -2)
        testBoard.movePlayer(player1, 3)
        testBoard.movePlayer(player2, 3)

        for ((index, spot) in testBoard.getTrack().withIndex()) {
            assertEquals(exceptedTrack[index], spot)
        }
    }

    @Test
    fun `Move NPC player in the same sector from straight area`() {
    }

    @Test
    fun `Move NPC player from straight area to legend area (using corner position)`() {
    }

    @Test
    fun `Move NPC player from the legend area to next sector`() {
    }
}