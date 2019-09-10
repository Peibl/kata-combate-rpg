package action

import repository.RPGCharacters

class CureCharacter(var rpgCharacters: RPGCharacters) {

    fun execute(toId: Int, health: Int) {

        val rpgCharacter = this.rpgCharacters.findById(toId)
        rpgCharacter.increaseHealthIn(health)
    }
}
