package common

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SectorTest {
    private val testSector = Sector(1, 3, 2, 1)

    @Test
    fun getOrder() {
        val excepted = 1
        assertEquals(excepted, testSector.getOrder())
    }

    @Test
    fun getSpotsNumber() {
        val excepted = 8
        assertEquals(excepted, testSector.getSpotsNumber())
    }

    @Test
    fun getSpacesNumber() {
        val excepted = 4
        assertEquals(excepted, testSector.getSpacesNumber())
    }

    @Test
    fun getSpeed() {
        val excepted = 2
        assertEquals(excepted, testSector.getSpeed())
    }

    @Test
    fun getLegendLength() {
        val excepted = 4
        assertEquals(excepted, testSector.getLegendLength())
    }

    @Test
    fun getStartingPosition() {
        val excepted = null
        assertEquals(excepted, testSector.getStartingPosition())
    }

    @Test
    fun getFinishPosition() {
        val excepted = null
        assertEquals(excepted, testSector.getFinishPosition())
    }

    @Test
    fun getSpotsToCorner() {
        val excepted = null
        assertEquals(excepted, testSector.getSpotsToCorner())
    }

    @Test
    fun getStraightLength() {
        val excepted = 4
        assertEquals(excepted, testSector.getLegendLength())
    }

    @Test
    fun isChicane() {
        val excepted = false
        assertEquals(excepted, testSector.isChicane())
    }
}