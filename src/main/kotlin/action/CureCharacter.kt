package action

import repository.RPGCharacters

class CureCharacter(var rpgCharacters: RPGCharacters) {

    fun execute(id: Int, health: Int) {
        val rpgCharacter = this.rpgCharacters.findById(id)
        rpgCharacter.increaseHealthIn(health)
    }
}
