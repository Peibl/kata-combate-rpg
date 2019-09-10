package action

import domain.RPGCharacter
import repository.RPGCharacters
import java.lang.RuntimeException

class AttackCharacter(var rpgCharacters: RPGCharacters) {


    fun execute( toId: Int, damage: Int) {
        val character = this.rpgCharacters.findById(toId)
        character.decreaseHealthIn(damage)
    }

}
