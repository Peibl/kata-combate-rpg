package action

import infrastructure.Characters
import java.lang.UnsupportedOperationException

class CureCharacterAction(var characters: Characters) {

    fun execute(fromtId: Int, toId: Int, health: Int) {
        if (fromtId !== toId) {
            throw UnsupportedOperationException()
        }
        val rpgCharacter = this.characters.findById(toId)
        rpgCharacter.increaseHealthIn(health)
    }
}
