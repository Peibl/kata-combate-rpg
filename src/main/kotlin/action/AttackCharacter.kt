package action

import domain.RPGCharacter
import repository.RPGCharacters
import java.lang.RuntimeException

class AttackCharacter(var rpgCharacters: RPGCharacters) {


    fun execute(fromId: Int, toId: Int, damage: Int): RPGCharacter {
        if(fromId== toId){
            throw RuntimeException()
        }
        val findById = this.rpgCharacters.findById(toId)
        findById.decreaseHealthIn(damage)
        return findById
    }

}
