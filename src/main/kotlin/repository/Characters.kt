package repository

import domain.Character

class Characters {
    private var id = 1;
    private val rpgCharacters = mutableListOf<Character>()
    fun findById(id: Int): Character {
        return this.rpgCharacters.filter { it.id == id }.single()
    }

    fun add(character: Character) {
        character.id = this.id++
        this.rpgCharacters.add(character)
    }

}