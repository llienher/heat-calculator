package common

class Spot (
    var numSector: Int = -1,
    var type: SpotType = SpotType.LEGEND,
    var boardPosition: Int = -1,
    var player: Player? = null,
) {
    fun isOccupied(): Boolean {
        return player != null
    }
}