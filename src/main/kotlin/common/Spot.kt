package common

data class Spot(
    var numSector: Int = -1,
    var type: SpotType = SpotType.LEGEND,
    var trackIndex: Int = -1,
    var boardLabel: Int = -1,
    var player: Player? = null,
) {
    fun isOccupied(): Boolean {
        return player != null
    }
}