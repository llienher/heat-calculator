package common

class BoardManager(private val country: String, private var laps: Int = 2, private val players: List<Player>) {
    private var ranking = players

    init {
        when (country) {
            "UK" -> println("UK not available.")
            "France" -> println("France not available.")
            "Italy" -> println("Italy not available.")
            "USA" -> println("USA not available.")
            "Japan" -> println("Japan not available.")
            "Mexico" -> initializeBoardMexico(laps)
        }
    }

    private fun initializeBoardMexico(laps: Int) {
        val mexicoSectors = listOf(
            Sector(order = 1, length = 22, cornerSpeed = 7, legendArea = 9, start = 14),
            Sector(order = 2, length = 4, cornerSpeed = 7, legendArea = 4),
            Sector(order = 3, length = 18, cornerSpeed = 6, legendArea = 8),
            Sector(order = 4, length = 5, cornerSpeed = 4, legendArea = 5),
            Sector(order = 5, length = 5, cornerSpeed = 2, legendArea = 4),
            Sector(order = 6, length = 0, cornerSpeed = 2, legendArea = 0),
        )
        val board = Board("Mexico", laps, 60, mexicoSectors)
        board.initTrack()
    }
}