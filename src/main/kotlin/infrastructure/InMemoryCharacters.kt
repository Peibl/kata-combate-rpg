package infrastructure

import domain.Character

class InMemoryCharacters : Characters {
    private var id = 1;
    private val rpgCharacters = mutableListOf<Character>()
    override fun findById(id: Int): Character {
        return this.rpgCharacters.filter { it.id == id }.single()
    }

    override fun add(character: Character) {
        character.id = this.id++
        this.rpgCharacters.add(character)
    }

}