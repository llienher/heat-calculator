package common

class Player(color: PlayerColor, type: PlayerType) {
    var color: PlayerColor = PlayerColor.RED
    var type: PlayerType = PlayerType.NPC
    var position: Int = -99 // on track index
    var ranking: Int = -1
    var currentSector: Int = -1

    init {
        this.color = color
        this.type = type
    }
}