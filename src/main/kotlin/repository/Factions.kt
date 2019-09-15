package repository

import domain.FACTIONS
import domain.Faction

class Factions {

    fun findById(id: Int): Faction {
        return FACTIONS.values().filter { it.id == id }[0]
    }
}