package action

import domain.Character
import domain.FACTIONS
import domain.FullHealth
import domain.Melee
import repository.Characters

class CreateCharacter(var characters: Characters) {
    var INITIAL_LEVEL = 1

    fun execute(): Character {
        val rpgCharacter = Character(INITIAL_LEVEL, 0, Melee(), mutableListOf(), FullHealth())
        this.characters.add(rpgCharacter)
        return rpgCharacter;
    }


}