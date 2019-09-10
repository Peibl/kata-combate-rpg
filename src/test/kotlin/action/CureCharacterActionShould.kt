package action

import domain.Health
import domain.NoneHealth
import domain.RPGCharacter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.RPGCharacters
import java.lang.UnsupportedOperationException


internal class CureCharacterActionShould {
    private val SOME_HEALTH: Int = 50
    var characters = RPGCharacters()
    @Before
    fun setUp() {
        this.characters = RPGCharacters()
    }

    @Test
    fun `increase character health in indicate amount`() {
        val damageCharacter = givenADamageCharacterWithHealthIn(900f)

        val healthToCure = 50
        CureCharacter(characters).execute(damageCharacter.id, healthToCure)

        Assert.assertEquals(950f, damageCharacter.healthAmount())
    }

    @Test
    fun `increase health to the maximum if the amount exceeds the maximum limit`() {
        val damageCharacter = givenADamageCharacterWithHealthIn(900f)

        val healthToCure = 500
        CureCharacter(characters).execute(damageCharacter.id, healthToCure)

        Assert.assertEquals(1000f, damageCharacter.healthAmount())
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if the character is dead`() {
        val deadCharacter = givenADeadCharacter()

        CureCharacter(characters).execute(deadCharacter.id, SOME_HEALTH)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try to cure a full health character`() {
        val deadCharacter = givenAFullHealthCharacter()

        CureCharacter(characters).execute(deadCharacter.id, SOME_HEALTH)
    }

    private fun givenAFullHealthCharacter(): RPGCharacter {
        val character = RPGCharacter(1, 1)
        this.characters.add(character)
        return character
    }


    private fun givenADamageCharacterWithHealthIn(health: Float): RPGCharacter {
        val character = RPGCharacter(1, 1)
        character.health = Health(health, character)
        this.characters.add(character)
        return character
    }

    private fun givenADeadCharacter(): RPGCharacter {
        val character = RPGCharacter(1, 1)
        character.health = NoneHealth(character)
        this.characters.add(character)
        return character
    }

}