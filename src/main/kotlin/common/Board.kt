package common

class Board(name: String, laps: Int, spaces: Int, private val sectors: List<Sector>) {
    private val title = name.uppercase()
    private val totalLap = laps
    private val totalSpaces = spaces
    private val totalSpots = totalSpaces * 2
    private val track = MutableList(totalSpots) { Spot() }

    init {
        println("Starting the Grand Prix of $title, for $totalLap laps of $totalSpaces spaces !")
        for (sector: Sector in sectors) {
            if (sector.getStartingPosition() !== null) {
                println("Starting position is on spot ${sector.getStartingPosition()}")
            }
            println(
                "Sector ${sector.getOrder()} is ${sector.getSpots()} spaces, " +
                        "braking is ${sector.getLegendSpots()} long, on gear ${sector.getSpeed()}."
            )
        }
        println("Track initiated: ${track.size} spots")
    }

    fun getTrack(): MutableList<Spot> {
        return this.track
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
