package common

class BoardManager(private val country: String, private var laps: Int = 0, private val players: List<Player>) {
    private var ranking = players

    init {
        when (country) {
            "UK" -> println("UK not available.")
            "France" -> println("France not available.")
            "Italy" -> println("Italy not available.")
            "USA" -> println("USA not available.")
            "Japan" -> println("Japan not available.")
            "Mexico" -> initializeBoard()
        }
    }

    private fun initializeBoard() {
        if (laps == 0) {
            laps = 2
        }

        val mexicoSectors = listOf(
            Sector(1, 22, 7, 9, 14),
            Sector(2, 4, 7, 4),
            Sector(3, 18, 6, 8),
            Sector(4, 5, 4, 5),
            Sector(5, 5, 2, 4),
            Sector(6, 0, 2, 0),
        )
        Board("Mexico", laps, 60, mexicoSectors)
    }
}