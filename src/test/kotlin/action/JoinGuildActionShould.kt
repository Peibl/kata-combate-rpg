package action

import CharacterBuilder.Companion.aCharacter
import domain.GUILDS
import domain.exception.AlreadyJoinedGuildException
import org.junit.Test
import infrastructure.InMemoryCharacters
import org.assertj.core.api.Assertions.assertThat
import infrastructure.InMemoryGuilds


internal class JoinGuildActionShould {

    @Test()
    fun `assign guild to character without guild`() {
        var character = aCharacter().withGuilds(mutableListOf()).build()
        characters.add(character)

        JoinGuildAction(characters, guilds).execute(character.id, SOME_GUILD.id)

        assertThat(character.guilds).containsExactly(SOME_GUILD)
    }

    @Test()
    fun `assign guild to character with different guilds`() {
        var character = aCharacter().withGuilds(mutableListOf(SOME_GUILD)).build()
        characters.add(character)
        JoinGuildAction(characters, guilds).execute(character.id, ANOTHER_GUILD.id)

        assertThat(character.guilds).containsExactly(SOME_GUILD, ANOTHER_GUILD)
    }

    @Test(expected = AlreadyJoinedGuildException::class)
    fun `fail if try to join to a guild already joined`() {
        var character = aCharacter().withGuilds(mutableListOf(SOME_GUILD)).build()
        characters.add(character)

        JoinGuildAction(characters, guilds).execute(character.id, SOME_GUILD.id)
    }
    var characters = InMemoryCharacters()
    var guilds = InMemoryGuilds()
    val SOME_GUILD = GUILDS.BLUE_GUILD
    val ANOTHER_GUILD = GUILDS.RED_GUILD
}
