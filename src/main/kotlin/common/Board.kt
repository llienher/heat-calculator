package common

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
        var spotInitiated = 0
        for ((index, sector) in sectors.withIndex()) {
            // TODO: logic sector 1
            // track last segment: from starting line to 0
            // track first segment: from sector.size to starting line

            // TODO: logic sector 2+
            // track: from sector.size to 0
            spotInitiated = this.assignSpots(sector, spotInitiated)
        }
    }

    fun assignSpots(sector: Sector, spotCount: Int): Int {
        var index = spotCount
        val straightToSet = index + sector.getStraightLength()
        val max = index + sector.getSpotsNumber()

        // Assign spot until end of the sector
        while (index < max) {
            val spot = this.track[index]
            spot.numSector = sector.getOrder()
            spot.type = if (index < straightToSet) SpotType.STRAIGHT else SpotType.LEGEND
            spot.boardPosition = index
            index++
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

    fun movePlayerOnTrack(player: Player, move: Int) {
        val position = positionNearRaceLine(player.position)
        val newPosition = position + Utils.fromNumberToSpot(move)
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
