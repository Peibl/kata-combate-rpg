package action

import CharacterBuilder.Companion.aCharacter
import domain.Health
import domain.ZeroHealth
import domain.Character
import org.junit.Before
import org.junit.Test
import infrastructure.InMemoryCharacters


internal class CureCharacterActionShould {

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try to increase another character health in indicate amount`() {
        val damageCharacter = aCharacter().withHealth(Health(900f)).build();
        val healer = aCharacter().build();
        this.characters.add(damageCharacter)
        this.characters.add(healer)

        val healthToCure = 50
        CureCharacterAction(characters).execute(healer.id, damageCharacter.id, healthToCure)

    }
    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try increase health to the maximum if the amount exceeds the maximum limit`() {
        val damageCharacter = aCharacter().withHealth(Health(900f)).build();
        val healer = aCharacter().build();
        this.characters.add(damageCharacter)
        this.characters.add(healer)
        val healthToCure = 500

        CureCharacterAction(characters).execute(healer.id, damageCharacter.id, healthToCure)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if the character is dead`() {
        val deadCharacter = aCharacter().withHealth(ZeroHealth()).build();
        val healer = aCharacter().build();
        this.characters.add(deadCharacter)
        this.characters.add(healer)

        CureCharacterAction(characters).execute(healer.id, deadCharacter.id, SOME_HEALTH)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if try to cure a full health character`() {
        val character = aCharacter().build()
        val healer = aCharacter().build();
        this.characters.add(character)
        this.characters.add(healer)

        CureCharacterAction(characters).execute(healer.id, character.id, SOME_HEALTH)
    }

    private val SOME_HEALTH: Int = 50
    var characters = InMemoryCharacters()
}
