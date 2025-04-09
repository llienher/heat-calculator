package common

class Sector(
    private val order: Int,
    length: Int = 0,
    cornerSpeed: Int = 0,
    brakingArea: Int = length,
    start: Int? = null
) {
    private val spaces = length + 1
    private val spots: Int = Utils.fromNumberToSpot(spaces)
    private val speed = cornerSpeed // only for display
    private val legendSpots = Utils.fromNumberToSpot((brakingArea + 1))
    private val straightSpots: Int = spots - legendSpots;
    private var startSpot: Int? = null;
    private var finishSpot: Int? = null;
    private var spotsToCorner: Int? = null;

    init {
        if (start !== null) {
            startSpot = Utils.fromNumberToSpace(start)
            finishSpot = Utils.fromNumberToSpace(start) - 1
            spotsToCorner = spots - startSpot!!;
        }
    }

    fun getOrder(): Int {
        return this.order;
    }

    fun getSpotsNumber(): Int {
        return this.spots;
    }

    fun getSpeed(): Int {
        return this.speed
    }

    fun getLegendLength(): Int {
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
        return this.straightSpots
    }

    fun isChicane(): Boolean {
        return this.straightSpots == 0;
    }
}