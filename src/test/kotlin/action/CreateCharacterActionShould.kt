package action

import domain.NoFaction
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.Characters


internal class CreateCharacterActionShould {
    var characters = Characters()
    val INITIAL_HEALTH = 1000f
    val INITIAL_LEVEL = 1
    @Before
    fun setUp() {
        this.characters = Characters()
    }

    @Test
    fun `create character`() {
        val createdCharacter = CreateCharacter(characters).execute()
        Assert.assertEquals(INITIAL_HEALTH, createdCharacter.healthAmount())
        Assert.assertEquals(INITIAL_LEVEL, createdCharacter.level)
        Assert.assertTrue(createdCharacter.isAlive())
    }
}