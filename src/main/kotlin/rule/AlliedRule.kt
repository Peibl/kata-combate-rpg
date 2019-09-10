package rule

import domain.Character
import java.lang.Math.abs

class AlliedRule(val attacker: Character, val victim: Character) : Rule {
    override fun verify() {
        if (attacker.faction.canAttack(victim)) {
            throw UnsupportedOperationException()
        }
    }
}