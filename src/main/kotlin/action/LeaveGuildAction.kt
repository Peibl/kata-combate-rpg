package action

import infrastructure.Characters
import infrastructure.Guilds

class LeaveGuildAction(var characters: Characters, var guilds: Guilds) {

    fun execute(id: Int, guildId: Int) {
        val character = this.characters.findById(id)
        val guild = guilds.findById(guildId)
        character.removeGuild(guild)
    }
}