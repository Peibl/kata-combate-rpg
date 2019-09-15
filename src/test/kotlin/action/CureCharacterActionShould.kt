package action

import CharacterBuilder.Companion.aCharacter
import domain.Health
import domain.NoneHealth
import domain.Character
import domain.Melee
import org.junit.Before
import org.junit.Test
import repository.Characters


internal class CureCharacterActionShould {
    private val SOME_HEALTH: Int = 50
    private val SOME_HEALER_ID: Int = 22
    var characters = Characters()
    @Before
    fun setUp() {
        this.characters = Characters()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try to increase another character health in indicate amount`() {
        val damageCharacter = givenADamageCharacterWithHealthIn(900f)

        val healthToCure = 50
        CureCharacter(characters).execute(SOME_HEALER_ID, damageCharacter.id, healthToCure)

    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try increase health to the maximum if the amount exceeds the maximum limit`() {
        val damageCharacter = givenADamageCharacterWithHealthIn(900f)

        val healthToCure = 500
        CureCharacter(characters).execute(SOME_HEALER_ID, damageCharacter.id, healthToCure)

    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if the character is dead`() {
        val deadCharacter = givenADeadCharacter()

        CureCharacter(characters).execute(SOME_HEALER_ID, deadCharacter.id, SOME_HEALTH)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try to cure a full health character`() {
        val deadCharacter = givenAFullHealthCharacter()

        CureCharacter(characters).execute(SOME_HEALER_ID, deadCharacter.id, SOME_HEALTH)
    }

    private fun givenAFullHealthCharacter(): Character {
        val character = aCharacter().build()
        this.characters.add(character)
        return character
    }


    private fun givenADamageCharacterWithHealthIn(health: Float): Character {
        val character = aCharacter().withHealth(Health(health)).build();
        this.characters.add(character)
        return character
    }

    private fun givenADeadCharacter(): Character {
        val character = aCharacter().withHealth(NoneHealth()).build();
        this.characters.add(character)
        return character
    }

}