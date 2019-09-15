package action

import CharacterBuilder.Companion.aCharacter
import domain.Health
import domain.NoneHealth
import domain.Character
import org.junit.Before
import org.junit.Test
import infrastructure.CharactersInMemory


internal class CureCharacterActionShould {
    private val SOME_HEALTH: Int = 50
    private val SOME_HEALER_ID: Int = 22
    var characters = CharactersInMemory()
    @Before
    fun setUp() {
        this.characters = CharactersInMemory()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try to increase another character health in indicate amount`() {
        val damageCharacter = givenADamageCharacterWithHealthIn(900f)

        val healthToCure = 50
        CureCharacterAction(characters).execute(SOME_HEALER_ID, damageCharacter.id, healthToCure)

    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try increase health to the maximum if the amount exceeds the maximum limit`() {
        val damageCharacter = givenADamageCharacterWithHealthIn(900f)

        val healthToCure = 500
        CureCharacterAction(characters).execute(SOME_HEALER_ID, damageCharacter.id, healthToCure)

    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if the character is dead`() {
        val deadCharacter = givenADeadCharacter()

        CureCharacterAction(characters).execute(SOME_HEALER_ID, deadCharacter.id, SOME_HEALTH)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try to cure a full health character`() {
        val deadCharacter = givenAFullHealthCharacter()

        CureCharacterAction(characters).execute(SOME_HEALER_ID, deadCharacter.id, SOME_HEALTH)
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