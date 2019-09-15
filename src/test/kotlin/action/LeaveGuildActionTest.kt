package action

import CharacterBuilder.Companion.aCharacter
import domain.GUILDS
import infrastructure.InMemoryCharacters
import infrastructure.InMemoryGuilds
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class LeaveGuildActionTest {
    @Test()
    fun `remove guild from character with one guild `() {
        var character = aCharacter().withGuilds(mutableListOf(SOME_GUILD)).build()
        characters.add(character)

        LeaveGuildAction(characters, guilds).execute(character.id, SOME_GUILD.id)

        assertThat(character.guilds).isEmpty()
    }

    @Test()
    fun `remove guild from character with two guild `() {
        var character = aCharacter().withGuilds(mutableListOf(SOME_GUILD, ANOTHER_GUILD)).build()
        characters.add(character)

        LeaveGuildAction(characters, guilds).execute(character.id, SOME_GUILD.id)

        assertThat(character.guilds).containsExactly(ANOTHER_GUILD)
    }

    val SOME_GUILD = GUILDS.BLUE_GUILD
    val ANOTHER_GUILD = GUILDS.RED_GUILD
    var characters = InMemoryCharacters()
    var guilds = InMemoryGuilds()
}