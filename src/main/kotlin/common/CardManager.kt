package common

class CardManager(players: List<Player>) {
    var possiblePlayerMoves: MutableList<PossiblePlayerMoveInfo> = ArrayList() // List of possible move for all players
    var possibleCardMoves: MutableList<MoveInfo> = createMoveInfoList()
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
            possiblePlayerMoves.add(PossiblePlayerMoveInfo(player.color, createMoveInfoList()))
        }
    }

    fun createOnePlayerMove(color: PlayerColor): PlayerMoveInfo {
        // Get the move list for this player
        val possibilities = possiblePlayerMoves.find { it.color == color }
        if (possibilities === null) {
            throw Exception("Not possible to generate player move.")
        }

        // Get only the possible moves allowed to this player and this card
        val thisPlayerMoves = possibilities.possibleMoveInfo
        val intersectedMoves = possibleCardMoves.intersect(thisPlayerMoves).toList()

        // Generate a move
        val randomNumber = (1..intersectedMoves.size).random()
        val move = PlayerMoveInfo(color, intersectedMoves[randomNumber])

        // Remove used moves
        thisPlayerMoves.remove(move.moveInfo)
        possibleCardMoves.remove(move.moveInfo)

        return move
    }

    fun createOneCard(players: List<Player>): Card {
        val cardMoves: MutableList<PlayerMoveInfo> = ArrayList() // Inside list of the card
        for (player in players) {
            val playerMove = createOnePlayerMove(player.color)
            cardMoves.add(playerMove)
        }
        return Card(cardMoves)
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

data class MoveInfo(var zone: Int, var move: Int)

data class PossiblePlayerMoveInfo(val color: PlayerColor, var possibleMoveInfo: MutableList<MoveInfo>)

data class PlayerMoveInfo(val color: PlayerColor, val moveInfo: MoveInfo)
