package action

import CharacterBuilder.Companion.aCharacter
import ThingBuilder.Companion.aThing
import domain.exception.ThingDestroyedException
import infrastructure.InMemoryCharacters
import infrastructure.InMemoryThings
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert
import org.junit.Test


internal class AttackThingActionShould {
    @Test
    fun `decrease health from thing in indicate damage`() {
        val character = aCharacter().build()
        val thing = aThing().named("Arbol").withHealth(SOME_HEALTH).build()
        characters.add(character)
        things.add(thing)
        AttackThingAction(characters, things).execute(character.id, thing.id, SOME_DAMAGE)

        assertThat(SOME_HEALTH - SOME_DAMAGE).isEqualTo(thing.health)
    }

    @Test(expected = ThingDestroyedException::class)
    fun `destroy thing if damage is greater than health`() {
        val character = aCharacter().build()
        val thing = aThing().withHealth(SOME_HEALTH).build()
        characters.add(character)
        things.add(thing)

        AttackThingAction(characters, things).execute(character.id, thing.id, SOME_HEALTH + SOME_DAMAGE)
    }

    var characters = InMemoryCharacters()
    var things = InMemoryThings()
    private val SOME_DAMAGE = 50
    private val SOME_HEALTH = 50
}