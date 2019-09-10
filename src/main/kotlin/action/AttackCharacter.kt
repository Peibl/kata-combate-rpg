package action

import repository.Characters
import rule.AutoAttackRule
import rule.RangeRule
import java.lang.Math.abs

class AttackCharacter(var characters: Characters) {


    fun execute(fromId: Int, toId: Int, damage: Int) {
        AutoAttackRule(fromId, toId).verify()
        var d = damage
        val attacker = this.characters.findById(fromId)
        val victim = this.characters.findById(toId)

        if ((victim.level - attacker.level) >= 5) {
            d = damage / 2
        }

        if ((attacker.level - victim.level) >= 5) {
            d = damage + (damage / 2)
        }

        RangeRule(attacker, victim).verify()

        victim.decreaseHealthIn(d)
    }


}
