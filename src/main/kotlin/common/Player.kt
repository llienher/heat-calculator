package common

class Player(color: PlayerColor, type: PlayerType) {
    val color: PlayerColor = PlayerColor.RED
    val type: PlayerType = PlayerType.AI
    var position: Int = -99 // on track index
    var ranking: Int = -1
    var currentSector: Int = -1
}