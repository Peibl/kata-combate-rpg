package domain

class Plateau(val rows: Int, val columns: Int, val obstacles: MutableList<Position> = mutableListOf()) {
    fun getNextPosition(position: Position, orientation: Orientation): Position {
        return when (orientation) {
            Orientation.NORTH -> getNorthernPosition(position)
            Orientation.EAST -> getEasternPosition(position)
            Orientation.SOUTH -> getSouthernPosition(position)
            Orientation.WEST -> getWesternPosition(position)
        }
    }

    private fun getNorthernPosition(position: Position): Position {
        val y = if (isLastRow(position)) firstRowIndex() else position.y + 1
        return Position(position.x, y)
    }

    private fun getSouthernPosition(position: Position): Position {
        val y = if (isFirstRow(position)) lastRowIndex() else position.y - 1
        return Position(position.x, y)
    }

    private fun getEasternPosition(position: Position): Position {
        val x = if (isLastColumn(position)) firstColumnIndex() else position.x + 1
        return Position(x, position.y)
    }

    private fun getWesternPosition(position: Position): Position {
        val x = if (isFirstColumn(position)) lastColumnIndex() else position.x - 1
        return Position(x, position.y)
    }

    private fun isFirstColumn(position: Position) = position.x == firstColumnIndex()
    private fun isLastColumn(position: Position) = position.x == lastColumnIndex()
    private fun lastColumnIndex() = columns - 1
    private fun firstColumnIndex() = 0

    private fun isFirstRow(position: Position) = position.y == firstRowIndex()
    private fun isLastRow(position: Position) = position.y == lastRowIndex()
    private fun lastRowIndex() = rows - 1
    private fun firstRowIndex() = 0

    fun existObstacleAt(pos: Position): Boolean {
        return obstacles.contains(pos)
    }

    fun registerObstacleAt(pos: Position) {
        obstacles.add(pos)
    }
}
