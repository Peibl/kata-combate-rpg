package infrastructure

import domain.Character

interface Characters {
    fun findById(id: Int): Character
    fun add(character: Character)
}