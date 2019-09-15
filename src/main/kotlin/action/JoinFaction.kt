package action

import repository.Characters

class JoinFaction(var characters: Characters) {

    fun execute(id: Int, factionId: Int) {
        val character = this.characters.findById(id)
//        character.faction = this.factions.findById(factionId)
    }
}