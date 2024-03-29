package action

import domain.rule.AlreadyJoinedGuildRule
import infrastructure.Characters
import infrastructure.Guilds

class JoinGuildAction(var characters: Characters, var guilds: Guilds) {

    fun execute(id: Int, guildId: Int) {
        val character = this.characters.findById(id)
        val guild = guilds.findById(guildId)
        AlreadyJoinedGuildRule(character, guild).verify()
        character.addGuild(guild)
    }
}