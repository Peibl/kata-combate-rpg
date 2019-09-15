package action

import CharacterBuilder.Companion.aCharacter
import domain.FACTIONS
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.Characters
import org.assertj.core.api.Assertions.assertThat
import repository.Factions


internal class JoinFactionActionShould {

    @Test()
    fun `assign faction to character without factions`() {
        var character = aCharacter().withFactions(mutableListOf()).build()
        characters.add(character)
        JoinFaction(characters, factions).execute(character.id, FACTIONS.BLUE_FACTION.id)

        assertThat(character.factions).containsExactly(FACTIONS.BLUE_FACTION)
    }

    var characters = Characters()
    var factions = Factions()

}