import domain.Robert
import org.junit.Assert
import org.junit.Test

class ARobertShould {
    @Test
    fun `move as specified when no obstacles`() {
        val robert = Robert(0, 0, "N")

        val result = robert.execute("F")

        Assert.assertEquals("10NOK", result)
    }

    @Test
    fun `stop moving when obstacle found` () {

        val robert = Robert(0, 0, "N")

        val result = robert.execute("F")

        Assert.assertEquals("00NNOK", result)
    }
}