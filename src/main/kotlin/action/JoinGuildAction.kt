package action

import infrastructure.Characters
import infrastructure.Guilds

class JoinGuildAction(var characters: Characters, var guilds: Guilds) {

    fun execute(id: Int, guildId: Int) {
        val character = this.characters.findById(id)
        val guild = guilds.findById(guildId)
        character.addGuild(guild)
    }
}