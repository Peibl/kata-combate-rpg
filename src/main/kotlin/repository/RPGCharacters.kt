package repository

import domain.RPGCharacter

class RPGCharacters {
    private var id = 1;
    private val rpgCharacters = mutableListOf<RPGCharacter>()
    fun findById(id: Int): RPGCharacter {
        return this.rpgCharacters.filter { it.id == id }.single()
    }

    fun add(rpgCharacter: RPGCharacter) {
        rpgCharacter.id = this.id++
        this.rpgCharacters.add(rpgCharacter)
    }

}