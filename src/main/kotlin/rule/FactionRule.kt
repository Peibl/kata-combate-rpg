package rule

import domain.Character
import exceptions.SameFactionException

class FactionRule(val attacker: Character, val victim: Character) : Rule {
    override fun verify() {
        for (faction in attacker.factions) {
            if (!faction.canAttack(victim)) {
                throw SameFactionException()
            }
        }
    }
}