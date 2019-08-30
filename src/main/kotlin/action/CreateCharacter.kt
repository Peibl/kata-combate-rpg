package action

import domain.RPGCharacter

class CreateCharacter {
    fun execute(): RPGCharacter {
        return RPGCharacter(1000, 1, true)
    }

}
