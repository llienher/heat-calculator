package common

class CardManager(players: List<Player>) {
    var playersMoves: MutableList<PlayerMoveInfo> = ArrayList()
    var possibleMoves: MutableList<PossiblePlayerMoveInfo> = ArrayList()
    var zoneQuotas = emptyList<Int>()

    // val allMoves: IntArray = (10..19).toIntArray()

    init {
        // Set the quotas related to the number of CPUs
        zoneQuotas = if (players.size <= 6) {
            listOf(2, 3, 3, 2)
        } else {
            listOf(2,4,4,2)
        }
        // Set a list of usable moves for each player
        for (player in players) {
            possibleMoves.add(PossiblePlayerMoveInfo(player.color, createMoveInfoList()))
        }
    }

    fun createOnePlayerMove(color: PlayerColor): PlayerMoveInfo {
        // Get the possible move list for this player
        val possibilities = possibleMoves.find { it.color == color }
        if (possibilities === null) {
            throw Exception("Not possible to generate player move.")
        }

        val randomNumber = (1..possibilities.possibleMoveInfo.size).random()
        val move = PlayerMoveInfo(color, possibilities.possibleMoveInfo[randomNumber])
        possibilities.possibleMoveInfo.removeAt(randomNumber)
        return move
    }

    fun createOneCard(players: List<Player>): Card {
        for (player in players) {
            val playerMove = createOnePlayerMove(player.color)
            playersMoves.add(playerMove)
        }
        return Card(playersMoves)
    }

    fun createMoveInfoList(): ArrayList<MoveInfo> {
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

data class Card(val moves: MutableList<PlayerMoveInfo>)

data class MoveInfo(var zone: Int, var move: Int) {
    companion object {} // For tests
}

data class PossiblePlayerMoveInfo(val color: PlayerColor, var possibleMoveInfo: MutableList<MoveInfo>)

data class PlayerMoveInfo(val color: PlayerColor, val moveInfo: MoveInfo)
