package action

import domain.RPGCharacter
var INITIAL_HEALTH = 1000
var INITIAL_LEVEL = 1
class CreateCharacter {
    fun execute(): RPGCharacter {
        return RPGCharacter(INITIAL_HEALTH, INITIAL_LEVEL, true)
    }

}
