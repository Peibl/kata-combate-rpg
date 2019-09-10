package rule

import domain.Character
import java.lang.Math.abs

class RangeRule(val attacker: Character, val victim: Character) : Rule {
    override fun verify() {
        if (abs(attacker.position - victim.position) > attacker.attackType.range) {
            throw UnsupportedOperationException()
        }
    }
}