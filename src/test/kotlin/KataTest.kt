import org.junit.Assert
import org.junit.Test
import kotlin.test.assertTrue

class KataTest {
    @Test
    fun `xxx`() {
        //given()
        val id = 1
        //a roberto in position 0 0 and north orientation
        val robert1= Robert(0,0,"N")

        //when
        val ttt = SendCommand(listOf(robert1)).execute(id, "F")


        val expectedResponse = "10NOK"
        Assert.assertEquals(expectedResponse, ttt)
    }
}