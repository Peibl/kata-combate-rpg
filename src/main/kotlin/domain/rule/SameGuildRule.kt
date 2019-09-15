package domain.rule

import domain.Character
import domain.exception.SameGuildException

class SameGuildRule(val attacker: Character, val victim: Character) : Rule {
    override fun verify() {
        for (guild in attacker.guilds) {
            if (!guild.canAttack(victim)) {
                throw SameGuildException()
            }
        }
    }
}