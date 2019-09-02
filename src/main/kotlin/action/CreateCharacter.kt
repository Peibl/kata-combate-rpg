package action

import domain.RPGCharacter
import repository.RPGCharacters

var INITIAL_HEALTH = 1000
var INITIAL_LEVEL = 1
class CreateCharacter(var rpgCharacters: RPGCharacters) {
    fun execute(): RPGCharacter {
        val rpgCharacter = RPGCharacter(INITIAL_HEALTH, INITIAL_LEVEL, true)
        this.rpgCharacters.add(rpgCharacter)
        return rpgCharacter;
    }

}
