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
            Sector(order = 1, length = 22, cornerSpeed = 7, brakingArea = 9, start = 14),
            Sector(order = 2, length = 4, cornerSpeed = 7, brakingArea = 4),
            Sector(order = 3, length = 18, cornerSpeed = 6, brakingArea = 8),
            Sector(order = 4, length = 5, cornerSpeed = 4, brakingArea = 5),
            Sector(order = 5, length = 5, cornerSpeed = 2, brakingArea = 4),
            Sector(order = 6, length = 0, cornerSpeed = 2, brakingArea = 0),
        )
        Board("Mexico", laps, 60, mexicoSectors)
    }
}