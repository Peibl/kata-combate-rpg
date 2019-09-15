package action

import domain.DamageRule
import repository.Characters
import rule.AutoAttackRule
import rule.FactionRule
import rule.RangeRule

class AttackCharacter(var characters: Characters) {


    fun execute(fromId: Int, toId: Int, damageValue: Int) {
        val attacker = this.characters.findById(fromId)
        val victim = this.characters.findById(toId)

        AutoAttackRule(fromId, toId).verify()
        RangeRule(attacker, victim).verify()
        FactionRule(attacker,victim).verify()

        var damage = DamageRule(damageValue)
        damage.calculate(victim, attacker)
        victim.decreaseHealthIn(damage.value)
    }


}
