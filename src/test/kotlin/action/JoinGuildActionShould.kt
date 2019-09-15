package action

import CharacterBuilder.Companion.aCharacter
import domain.GUILDS
import org.junit.Test
import infrastructure.CharactersInMemory
import org.assertj.core.api.Assertions.assertThat
import infrastructure.GuildsInMemory


internal class JoinGuildActionShould {

    @Test()
    fun `assign guild to character without guild`() {
        var character = aCharacter().withGuilds(mutableListOf()).build()
        characters.add(character)
        JoinGuildAction(characters, guilds).execute(character.id, GUILDS.BLUE_GUILD.id)

        assertThat(character.guilds).containsExactly(GUILDS.BLUE_GUILD)
    }

    var characters = CharactersInMemory()
    var guilds = GuildsInMemory()

}