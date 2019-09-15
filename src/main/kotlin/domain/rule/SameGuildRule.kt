package domain.rule

import domain.Gremiable
import domain.exception.SameGuildException

class SameGuildRule(val attacker: Gremiable, val victim: Gremiable) : Rule {
    override fun verify() {
        if (attacker.shareGuildWith(victim)) {
            throw SameGuildException()
        }
    }
}