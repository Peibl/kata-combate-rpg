package action

import org.junit.Assert
import org.junit.Test

class SendCommandToRoverTest {
    private val SOME_ROVER_ID = 1
    @Test
    fun `move it forward one position when an F command is sent`() {
        val rovers = RoversInMemory()

        val result = SendCommandToRover(rovers).execute(SOME_ROVER_ID, "F")

        Assert.assertEquals("10NOK", result)
    }
/*
    @Test
    fun `stop moving when obstacle found`() {
        val obstacles = mutableListOf(Position(0, 1))
        val plateau = Plateau(2, 2, obstacles)
        val rover = Rover(Position(0, 0), Orientation.NORTH, SOME_ROVER_ID)


        val result = SendCommandToRover().execute(SOME_ROVER_ID, "F")
        Assert.assertEquals("00NNOK", result)
    } */
}