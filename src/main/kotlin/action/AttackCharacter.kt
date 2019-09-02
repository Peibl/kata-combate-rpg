package action

import domain.RPGCharacter
import repository.RPGCharacters

class AttackCharacter(var rpgCharacters: RPGCharacters) {


    fun execute(toId: Int, damage: Int): RPGCharacter {
        val findById = this.rpgCharacters.findById(toId)
        findById.decreaseHealthIn(damage)
        return findById
    }

}
