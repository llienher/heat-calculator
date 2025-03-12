package common

class Spot (
    var numSector: Int,
    var type: SpotType = SpotType.LEGEND,
    var player: Player? = null
) {
    fun isOccupied(): Boolean {
        return player != null
    }
}