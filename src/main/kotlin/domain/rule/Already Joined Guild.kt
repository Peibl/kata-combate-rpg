package domain.rule

import domain.Character
import domain.Guild
import domain.exception.AlreadyJoinedGuildException

class AlreadyJoinedGuildRule(val character: Character, val guild: Guild) : Rule {
    override fun verify() {
        if (character.guilds.contains(guild)) {
            throw AlreadyJoinedGuildException()
        }
    }
}