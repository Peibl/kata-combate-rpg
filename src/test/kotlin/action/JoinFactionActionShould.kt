package action

import CharacterBuilder.Companion.aCharacter
import domain.NoFaction
import domain.Ranged
import domain.SomeFaction
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.Characters
import repository.Factions


internal class JoinFactionActionShould {
    var characters = Characters()
    var factions = Factions()
    var SOME_FACTION = SomeFaction();
    @Before
    fun setUp() {
        this.characters = Characters()
        this.factions = Factions()
    }

    @Test()
    fun `assing faction to character`() {
        val character = aCharacter().build();
        this.characters.add(character)

        factions.add(NoFaction())
        factions.add(SOME_FACTION)

        JoinFaction(characters, factions).execute(character.id, SOME_FACTION.id)

        Assert.assertEquals(character.faction.id,SOME_FACTION.id)
    }

}