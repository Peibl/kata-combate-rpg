package action

import repository.Characters
import repository.Factions

class JoinFaction(var characters: Characters, var factions: Factions) {

    fun execute(id: Int, factionId: Int) {
        val character = this.characters.findById(id)
        character.faction = this.factions.findById(factionId)
    }
}