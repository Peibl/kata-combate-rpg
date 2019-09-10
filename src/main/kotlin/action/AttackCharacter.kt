package action

import domain.Damage
import repository.Characters
import rule.AutoAttackRule
import rule.RangeRule
import java.lang.Math.abs

class AttackCharacter(var characters: Characters) {


    fun execute(fromId: Int, toId: Int, damageValue: Int) {
        val attacker = this.characters.findById(fromId)
        val victim = this.characters.findById(toId)

        AutoAttackRule(fromId, toId).verify()
        RangeRule(attacker, victim).verify()

        var damage = Damage(damageValue)
        damage.recalculate(victim, attacker)
        victim.decreaseHealthIn(damage.value)
    }


}
