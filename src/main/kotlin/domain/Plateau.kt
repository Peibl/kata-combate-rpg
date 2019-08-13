package domain

class Plateau(val rows: Int, val columns: Int) {
    fun getNextPosition(position: Position, orientation: String): Position {
        return Position(1, 0)
    }
}
