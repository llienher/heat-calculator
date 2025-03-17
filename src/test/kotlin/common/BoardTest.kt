package common

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

 class BoardTest {
  private val testSectorList = List(1) { Sector(1, 3, 2, 1) }
  private val testBoard = Board("test", 1, 4, testSectorList)

  @Test
   fun getTrack() {}

  @Test
  fun assignSpots() {
    val resultTrack = MutableList(8) {
     Spot(1, SpotType.STRAIGHT)
     Spot(1, SpotType.STRAIGHT )
     Spot(1, SpotType.STRAIGHT)
     Spot(1, SpotType.STRAIGHT)
     Spot(1, SpotType.LEGEND)
     Spot(1, SpotType.LEGEND)
     Spot(1, SpotType.LEGEND)
     Spot(1, SpotType.LEGEND)
    }
   val assignedSpots = testBoard.assignSpots(testSectorList[0], 0)
   assertEquals(resultTrack.size, assignedSpots)
   assertEquals(resultTrack, testBoard.getTrack())
  }

  @Test
  fun getTrackPosition() {}
 }