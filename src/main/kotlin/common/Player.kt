package common

class Player(color: PlayerColor, type: PlayerType) {
    val color: PlayerColor = PlayerColor.RED
    val type: PlayerType = PlayerType.AI
    val position: Int = -1 // on track index
    val ranking: Int = -1
    val currentSector: Int = -1
}