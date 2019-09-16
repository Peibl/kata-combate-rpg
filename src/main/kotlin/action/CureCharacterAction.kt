package action

import infrastructure.Characters

class CureCharacterAction(var characters: Characters) {

    fun execute(healerId: Int, curedId: Int, health: Int) {
        val cured = this.characters.findById(curedId)
        val healer = this.characters.findById(healerId)
        if (healerId !== curedId) {
            throw UnsupportedOperationException()
        }


        cured.increaseHealthIn(health)
    }
}
