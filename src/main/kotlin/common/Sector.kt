package common

class Sector(
    private val order: Int,
    length: Int = 0,
    cornerSpeed: Int = 0,
    brakingArea: Int = length,
    start: Int? = null
) {
    private val spaces = length + 1
    private val spots: Int = spaces * 2
    private val speed = cornerSpeed // only for display
    private var legendSpots = (brakingArea + 1) * 2
    private var startSpot: Int? = null;
    private var finishSpot: Int? = null;
    private var spotsToCorner: Int? = null;
    private var spotsInStraight: Int = 0;

    init {
        if (start !== null) {
            startSpot = start * 2
            finishSpot = (start * 2) - 1
            spotsToCorner = spots - startSpot!!;
            spotsInStraight = spots - legendSpots
        }
    }

    fun getOrder(): Int {
        return this.order;
    }

    fun getSpots(): Int {
        return this.spots;
    }

    fun getSpeed(): Int {
        return this.speed
    }

    fun getLegendSpots(): Int {
        return this.legendSpots;
    }

    fun getStartingPosition(): Int? {
        return this.startSpot;
    }

    fun getFinishPosition(): Int? {
        return this.finishSpot;
    }

    fun getSpotsToCorner(): Int? {
        return this.spotsToCorner;
    }

    fun getStraightLength(): Int {
        return this.spotsInStraight
    }
}