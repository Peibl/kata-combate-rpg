package action

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.RPGCharacters


internal class CreateCharacterActionShould {
    var repo = RPGCharacters()
    val INITIAL_HEALTH = 1000
    val INITIAL_LEVEL = 1
    @Before
    fun setUp() {
        this.repo = RPGCharacters()
    }

    @Test
    fun `create character`() {
        val createdCharacter = CreateCharacter(repo).execute()
        Assert.assertEquals(INITIAL_HEALTH, createdCharacter.health)
        Assert.assertEquals(INITIAL_LEVEL, createdCharacter.level)
        Assert.assertTrue(createdCharacter.alive)
    }
}