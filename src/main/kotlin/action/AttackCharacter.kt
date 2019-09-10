package action

import repository.RPGCharacters

class AttackCharacter(var rpgCharacters: RPGCharacters) {


    fun execute(fromId: Int, toId: Int, damage: Int) {
        if (fromId === toId) {
            throw UnsupportedOperationException()
        }
        var d = damage
        val attacker = this.rpgCharacters.findById(fromId)
        val victim = this.rpgCharacters.findById(toId)

        if ((victim.level - attacker.level) >= 5) {
            d = damage / 2
        }

        if ((attacker.level - victim.level) >= 5) {
            d = damage + (damage / 2)
        }

        victim.decreaseHealthIn(d)
    }

}
