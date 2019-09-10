package action

import repository.RPGCharacters
import java.lang.RuntimeException
import java.lang.UnsupportedOperationException

class CureCharacter(var rpgCharacters: RPGCharacters) {

    fun execute(fromtId: Int, toId: Int, health: Int) {
        if (fromtId !== toId) {
            throw UnsupportedOperationException()
        }
        val rpgCharacter = this.rpgCharacters.findById(toId)
        rpgCharacter.increaseHealthIn(health)
    }
}
