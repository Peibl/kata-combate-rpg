import domain.Plateau
import domain.Position
import org.junit.Assert
import org.junit.Test

class a2x2PlateauShould {
    @Test
    fun `return (1,0) as the northern position od (0,0)`() {
        val plateau = Plateau(2, 2)

        val nextPosition: Position = plateau.getNextPosition(Position(0, 0), "N")

        Assert.assertEquals(Position(1,0),nextPosition)
    }
}