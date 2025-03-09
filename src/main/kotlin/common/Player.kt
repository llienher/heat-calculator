package common

class Player(color: PlayerColor, type: PlayerType) {
    val color: PlayerColor = PlayerColor.RED
    val type: PlayerType = PlayerType.AI
    val position: Int = 0 // on track index
    val ranking: Int = 0
}