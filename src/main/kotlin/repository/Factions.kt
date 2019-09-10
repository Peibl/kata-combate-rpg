package repository

import domain.Character
import domain.Faction

class Factions {
    private var id = 1;
    private val factions = mutableListOf<Faction>()
    fun findById(id: Int): Faction {
        return this.factions.filter { it.id == id }.single()
    }

    fun add(faction: Faction) {
        this.factions.add(faction)
    }

}