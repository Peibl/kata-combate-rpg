package action

import domain.RPGCharacter
import repository.RPGCharacters

class CreateCharacter(var rpgCharacters: RPGCharacters) {
    var INITIAL_LEVEL = 1

    fun execute(): RPGCharacter {
        val rpgCharacter = RPGCharacter(INITIAL_LEVEL)
        this.rpgCharacters.add(rpgCharacter)
        return rpgCharacter;
    }


}