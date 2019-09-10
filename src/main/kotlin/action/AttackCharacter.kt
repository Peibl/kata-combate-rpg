package action

import repository.Characters
import java.lang.Math.abs

class AttackCharacter(var characters: Characters) {


    fun execute(fromId: Int, toId: Int, damage: Int) {
        if (fromId === toId) {
            throw UnsupportedOperationException()
        }
        var d = damage
        val attacker = this.characters.findById(fromId)
        val victim = this.characters.findById(toId)

        if ((victim.level - attacker.level) >= 5) {
            d = damage / 2
        }

        if ((attacker.level - victim.level) >= 5) {
            d = damage + (damage / 2)
        }

        if (abs(attacker.position - victim.position) > attacker.attackType.range) {
            throw UnsupportedOperationException()
        }

        victim.decreaseHealthIn(d)
    }

}
