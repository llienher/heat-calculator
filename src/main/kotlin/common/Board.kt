package common

class Board(name: String, laps: Int, spaces: Int, private val sectors: List<Sector>) {
    private val title = name.uppercase()
    private val totalLap = laps
    private val totalSpaces = spaces
    private val totalSpots = Utils.fromSpaceToSpot(totalSpaces)
    private val track = MutableList(totalSpots) { Spot(-1 ) }

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

    private fun initTrack() {
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
        val straightToSet = sector.getStraightLength()
        val max = index + sector.getSpotsNumber()

        // Assign spot until end of the sector
        while (index < max) {
            val spot = this.track[index]
            spot.numSector = sector.getOrder()
            spot.type = if (index < straightToSet) SpotType.STRAIGHT else SpotType.LEGEND
            index++
        }

        return max
    }

    fun getTrackPosition(player: Player?): Any {
        if (player != null) {
            for (spot in track) {
                val rank = 1
                if (spot.player != null) {
                    if (spot.player == player) {
                        println("Player is ranked $rank")
                    }
                    rank + 1
                }
            }
        }
        val ranking = mutableListOf<Player>()
        for (spot in track) {
            if (spot.player != null) {
                ranking.add(spot.player!!)
            }
        }
        return ranking
    }
}
