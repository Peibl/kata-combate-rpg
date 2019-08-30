import action.CreateCharacter
import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun `create character`() {
        val expectedCharacter = CreateCharacter().execute()
        Assert.assertEquals(1000, expectedCharacter.health)
        Assert.assertEquals(1, expectedCharacter.level)
        Assert.assertTrue( expectedCharacter.alive)

    }


}