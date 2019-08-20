import domain.Orientation
import domain.Plateau
import domain.Position
import org.junit.Assert
import org.junit.Test

class a2x2PlateauShould {
    @Test
    fun `return (0,1) as the northern position of (0,0)`() {
        val plateau = Plateau(2, 2)

        val nextPosition: Position = plateau.getNextPosition(Position(0, 0), Orientation.NORTH)

        Assert.assertEquals(Position(0, 1), nextPosition)
    }

    @Test
    fun `return (0,0) as the northern position of (0,1)`() {
        val plateau = Plateau(2, 2)

        val nextPosition: Position = plateau.getNextPosition(Position(0, 1), Orientation.NORTH)

        Assert.assertEquals(Position(0, 0), nextPosition)
    }

    @Test
    fun `return (1,0) as the eastern position of (0,0)`() {
        val plateau = Plateau(2, 2)

        val nextPosition: Position = plateau.getNextPosition(Position(0, 0), Orientation.EAST)

        Assert.assertEquals(Position(1, 0), nextPosition)
    }

    @Test
    fun `return (0,0) as the eastern position of (1,0)`() {
        val plateau = Plateau(2, 2)

        val nextPosition: Position = plateau.getNextPosition(Position(1, 0), Orientation.EAST)

        Assert.assertEquals(Position(0, 0), nextPosition)
    }

    @Test
    fun `return (0,1) as the southern position of (0,0)`() {
        val plateau = Plateau(2, 2)

        val nextPosition: Position = plateau.getNextPosition(Position(0, 0), Orientation.SOUTH)

        Assert.assertEquals(Position(0, 1), nextPosition)
    }

    @Test
    fun `return (0,0) as the southern position of (0,1)`() {
        val plateau = Plateau(2, 2)

        val nextPosition: Position = plateau.getNextPosition(Position(0, 1), Orientation.SOUTH)

        Assert.assertEquals(Position(0, 0), nextPosition)
    }


    @Test
    fun `return (1,0) as the western position of (0,0)`() {
        val plateau = Plateau(2, 2)

        val nextPosition: Position = plateau.getNextPosition(Position(0, 0), Orientation.WEST)

        Assert.assertEquals(Position(1, 0), nextPosition)
    }

    @Test
    fun `return (0,0) as the western position of (1,0)`() {
        val plateau = Plateau(2, 2)

        val nextPosition: Position = plateau.getNextPosition(Position(1, 0), Orientation.WEST)

        Assert.assertEquals(Position(0, 0), nextPosition)
    }

    @Test
    fun `return true if there is an obstacle at the given position`() {
        val plateau = Plateau(2, 2)
        val pos = Position(0, 0)
        plateau.registerObstacleAt(pos)
        Assert.assertTrue(plateau.existObstacleAt(pos))
    }

    @Test
    fun `return false if there  is not an obstacle at the given position`() {
        val plateau = Plateau(2, 2)
        val pos = Position(0, 0)
        Assert.assertFalse(plateau.existObstacleAt(pos))
    }


}