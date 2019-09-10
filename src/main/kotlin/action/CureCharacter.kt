package action

import repository.Characters
import java.lang.UnsupportedOperationException

class CureCharacter(var characters: Characters) {

    fun execute(fromtId: Int, toId: Int, health: Int) {
        if (fromtId !== toId) {
            throw UnsupportedOperationException()
        }
        val rpgCharacter = this.characters.findById(toId)
        rpgCharacter.increaseHealthIn(health)
    }
}
