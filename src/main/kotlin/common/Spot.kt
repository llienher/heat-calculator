package common

class Spot {
    val sector: Int = 0
    val type: SpotType = SpotType.LEGEND
    var player: Player? = null
    val position: Int = 0 // on the board, track index

    fun isOccupied(): Boolean {
        return player != null
    }
}