package action

import domain.DamageRule
import domain.rule.AutoAttackRule
import domain.rule.SameGuildRule
import domain.rule.RangeRule
import infrastructure.Characters

class AttackCharacterAction(var characters: Characters) {

    fun execute(fromId: Int, toId: Int, damageValue: Int) {
        val attacker = this.characters.findById(fromId)
        val victim = this.characters.findById(toId)

        AutoAttackRule(fromId, toId).verify()
        RangeRule(attacker, victim).verify()
        SameGuildRule(attacker, victim).verify()

        var damage = DamageRule(damageValue)
        damage.calculate(victim, attacker)
        victim.decreaseHealthIn(damage.value)
    }
}
