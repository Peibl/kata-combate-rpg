package action

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import infrastructure.InMemoryCharacters
import org.assertj.core.api.Assertions.assertThat


internal class CreateCharacterActionShould {
    var characters = InMemoryCharacters()
    val INITIAL_HEALTH = 1000f
    val INITIAL_LEVEL = 1
    @Before
    fun setUp() {
        this.characters = InMemoryCharacters()
    }

    @Test
    fun `create character`() {
        val createdCharacter = CreateCharacterAction(characters).execute()
        Assert.assertEquals(INITIAL_HEALTH, createdCharacter.healthAmount())
        Assert.assertEquals(INITIAL_LEVEL, createdCharacter.level)
        Assert.assertTrue(createdCharacter.isAlive())
        assertThat(createdCharacter.guilds).isEmpty()
    }
}