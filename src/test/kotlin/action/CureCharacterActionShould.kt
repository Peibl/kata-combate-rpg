package action

import CharacterBuilder.Companion.aCharacter
import domain.NormalHealthState
import domain.NoneHealthState
import domain.Character
import domain.GUILDS
import domain.exception.CantCureCharacterException
import domain.exception.CantCureFullHealthCharacterException
import domain.exception.DeathCharacterException
import org.junit.Test
import infrastructure.InMemoryCharacters
import org.assertj.core.api.Assertions.assertThat


internal class CureCharacterActionShould {

    @Test(expected = CantCureCharacterException::class)
    fun `fail if try to increase another character health in indicate amount`() {
        val damageCharacter = aCharacter().withHealth(NormalHealthState(SOME_HEALTH)).build();
        val healer = aCharacter().build();
        this.characters.add(damageCharacter)
        this.characters.add(healer)

        val healthToCure = 50
        CureCharacterAction(characters).execute(healer.id, damageCharacter.id, healthToCure)
    }

    @Test(expected = CantCureCharacterException::class)
    fun `fail if try increase health to the maximum if the amount exceeds the maximum limit`() {
        val damageCharacter = aCharacter().withHealth(NormalHealthState(SOME_HEALTH)).build();
        val healer = aCharacter().build();
        this.characters.add(damageCharacter)
        this.characters.add(healer)
        val healthToCure = 500

        CureCharacterAction(characters).execute(healer.id, damageCharacter.id, healthToCure)
    }

    @Test(expected = DeathCharacterException::class)
    fun `fail if the character is dead`() {
        val deadCharacter = aCharacter().withHealth(NoneHealthState()).withGuilds(mutableListOf(GUILDS.RED_GUILD)).build();
        val healer = aCharacter().withGuilds(mutableListOf(GUILDS.RED_GUILD)).build();
        this.characters.add(deadCharacter)
        this.characters.add(healer)

        CureCharacterAction(characters).execute(healer.id, deadCharacter.id, SOME_HEALTH_AMOUNT_TO_CURE)
    }

    @Test(expected = CantCureFullHealthCharacterException::class)
    fun `fail if try to cure a full health character`() {
        val character = aCharacter().withGuilds(mutableListOf(GUILDS.RED_GUILD)).build()
        val healer = aCharacter().withGuilds(mutableListOf(GUILDS.RED_GUILD)).build()
        this.characters.add(character)
        this.characters.add(healer)

        CureCharacterAction(characters).execute(healer.id, character.id, SOME_HEALTH_AMOUNT_TO_CURE)
    }

    @Test()
    fun `must heal an allied character`() {
        val character: Character =
            aCharacter().withHealth(NormalHealthState(SOME_HEALTH)).withGuilds(mutableListOf(GUILDS.RED_GUILD)).build()
        val healer = aCharacter().withGuilds(mutableListOf(GUILDS.RED_GUILD)).build()
        this.characters.add(character)
        this.characters.add(healer)

        CureCharacterAction(characters).execute(healer.id, character.id, SOME_HEALTH_AMOUNT_TO_CURE)
        assertThat(character.healthAmount()).isEqualTo(SOME_HEALTH + SOME_HEALTH_AMOUNT_TO_CURE)
    }

    @Test(expected = CantCureCharacterException::class)
    fun `fail if try to cure a character with other guild`() {
        val character = aCharacter().build()
        val healer = aCharacter().build();
        this.characters.add(character)
        this.characters.add(healer)

        CureCharacterAction(characters).execute(healer.id, character.id, SOME_HEALTH_AMOUNT_TO_CURE)
    }

    @Test()
    fun `increase character health if he heals himself`() {
        val character = aCharacter().withHealth(NormalHealthState(SOME_HEALTH)).build()
        this.characters.add(character)

        CureCharacterAction(characters).execute(character.id, character.id, SOME_HEALTH_AMOUNT_TO_CURE)
        assertThat(character.healthAmount()).isEqualTo(SOME_HEALTH + SOME_HEALTH_AMOUNT_TO_CURE)
    }

    val SOME_HEALTH_AMOUNT_TO_CURE: Int = 50
    val SOME_HEALTH = 900f
    var characters = InMemoryCharacters()
}
