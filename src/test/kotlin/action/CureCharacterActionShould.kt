package action

import domain.Health
import domain.RPGCharacter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.RPGCharacters


internal class CureCharacterActionShould {
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


    private fun givenADamageCharacterWithHealthIn(health: Float): RPGCharacter {
        val character = RPGCharacter(1, 1)
        character.health = Health(health, character)
        this.characters.add(character)
        return character
    }


}