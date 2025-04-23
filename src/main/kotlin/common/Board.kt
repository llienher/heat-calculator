package common

import kotlin.math.floor

class Board(name: String, laps: Int, spaces: Int, private val sectors: List<Sector>) {
    private val title = name.uppercase()
    private val totalLap = laps
    private val totalSpaces = spaces
    private val totalSpots = Utils.fromNumberToSpot(totalSpaces)
    private val track = MutableList(totalSpots) { Spot() }

    init {
        println("Starting the Grand Prix of $title, for $totalLap laps of $totalSpaces spaces !")
        for (sector: Sector in sectors) {
            if (sector.getStartingPosition() !== null) {
                println("Starting position is on spot ${sector.getStartingPosition()}")
            }
            println(
                "Sector ${sector.getOrder()} is ${sector.getSpotsNumber()} spots, " +
                        "Legend area is ${sector.getLegendLength()} long, corner on gear ${sector.getSpeed()}."
            )
        }
        //initTrack()
        println("Track initiated: ${track.size} spots")
    }

    fun getTrack(): MutableList<Spot> {
        return this.track
    }

    fun initTrack() {
        var indexPointer = 0
        for ((index, sector) in sectors.withIndex()) {
            // TODO: logic sector 1
            // track last segment: from starting line to 0
            // track first segment: from sector.size to starting line

            // TODO: logic sector 2+
            // track: from sector.size to 0
            indexPointer = this.assignSpots(sector, indexPointer)
        }
    }

    fun assignSpots(sector: Sector, indexPointer: Int): Int {
        var globalIndex = indexPointer
        val straightToSet = globalIndex + sector.getStraightLength()
        val max = globalIndex + sector.getSpotsNumber()
        var sectorIndex = 0.0

        // Assign spot until end of the sector
        while (globalIndex < max) {
            val spot = this.track[globalIndex]
            spot.numSector = sector.getOrder()
            spot.type = if (globalIndex < straightToSet) SpotType.STRAIGHT else SpotType.LEGEND
            spot.trackIndex = globalIndex
            val spacesAssigned = floor(sectorIndex / 2)
            spot.boardLabel = sector.length() - spacesAssigned.toInt()
            globalIndex++
            sectorIndex++
        }

        return max
    }

    fun getPlayersRanking(): MutableList<Player> {
        val ranking = mutableListOf<Player>()
        for (spot in track) {
            if (spot.player != null) {
                ranking.add(spot.player!!)
            }
        }
        return ranking
    }

    fun getPlayerRanking(player: Player): Int {
        val rank = 1
        for (spot in track) {
            if (spot.player != null) {
                if (spot.player == player) {
                    println("Player is ranked $rank")
                    break
                }
                rank + 1
            }
        }
        return rank
    }

    fun setPlayerStartingPosition(player: Player, startingPosition: Int) {
        player.position = startingPosition
    }

    fun movePlayer(player: Player, move: Int, cornerPosition: Int = -1) {
        if (player.type === PlayerType.NPC) {
            if (cornerPosition == -1) {
                throw Exception("Cannot move the NPC, no corner position is provided.")
            }

            // check where the NPC is after move
            val currentPosition = player.position
            val exceptedSlot = this.track[currentPosition + Utils.fromNumberToSpot(move)]
            val exceptedSector = exceptedSlot.numSector
            // TODO: check if move sector diff exceed two and there is chicane type in between


            // if in legend zone
            if (this.track[currentPosition].type === SpotType.LEGEND) {
                movePlayerOnBoard(player, move)
            } else {
                // if passes the corner
                if (exceptedSector > player.currentSector) {
                    positionPlayerOnBoard(player, cornerPosition)
                } else {
                    movePlayerOnBoard(player, move)
                }
            }
        } else {
            // Move the User player
            movePlayerOnBoard(player, move)
        }
    }

    private fun movePlayerOnBoard(player: Player, move: Int) {
        val position = positionNearRaceLine(player.position)
        val newPosition = position + Utils.fromNumberToSpot(move)
        addPlayerToSpot(player, newPosition)
    }

    private fun positionPlayerOnBoard(player: Player, position: Int) {
        val newPosition = positionNearRaceLine(Utils.fromNumberToSpot(position))
        addPlayerToSpot(player, newPosition)
    }

    // Odd numbers are near race line, even numbers are off race line
    private fun positionNearRaceLine(position: Int): Int {
        val modulo = position % 2
        return if (modulo == 0) {
            position + 1
        } else {
            position
        }
    }

    private fun addPlayerToSpot(player: Player, newPosition: Int) {
        val spot = track[newPosition]
        if (!spot.isOccupied()) {
            spot.player = player
        } else {
            println("Spot occupied, move to nearest available")
            addPlayerToSpot(player, newPosition - 1)
        }
    }
}
