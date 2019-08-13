import org.junit.Assert
import org.junit.Test
import kotlin.test.assertTrue

class KataTest {
    @Test
    fun `robert move as expected`() {
        val robert = Robert(0, 0, "N")
        val result = robert.execute("F")
        Assert.assertEquals("10NOK", result)
    }
}