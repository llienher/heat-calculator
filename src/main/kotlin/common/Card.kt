package common

import common.Utils.toIntArray

class Card(players: List<Player>) {
    val playersInfo = arrayListOf<PlayerMoveInfo>()
    var possibleMoves = emptyList<List<Int>>()
    val zoneQuotas = listOf(2, 3, 3, 2)

    // val allMoves: IntArray = (10..19).toIntArray()

    init {
        // TODO: get a list of usable moves for each players
    }

    fun setMoveInfo(player: PlayerColor) {
        val randomNumber = (1..10).random()
        // TODO: Get the zone and move in the possible move list (for this player)
        // TODO: Remove the selected index in possible move list
    }

    fun createCombinations(): ArrayList<MoveInfo> {
        val miList = arrayListOf<MoveInfo>()
        for (move in 10..19) {
            val zone = getZoneByMove(move)
            miList.add(MoveInfo(zone, move))
        }
        return miList
    }

    private fun getZoneByMove(move: Int): Int {
        return when (move) {
            in 10..11 -> 0
            in 12..14 -> 1
            in 14..17 -> 2
            in 18..19 -> 3
            else -> error("Move is out of range to get zone.")
        }
    }
}

data class PlayerMoveInfo(val color: PlayerColor, val moveInfo: MoveInfo)

data class MoveInfo(var zone: Int, var move: Int)
