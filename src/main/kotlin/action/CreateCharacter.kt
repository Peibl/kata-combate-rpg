package action

import domain.Character
import domain.Melee
import repository.Characters

class CreateCharacter(var characters: Characters) {
    var INITIAL_LEVEL = 1

    fun execute(): Character {
        val rpgCharacter = Character(INITIAL_LEVEL, 0, Melee())
        this.characters.add(rpgCharacter)
        return rpgCharacter;
    }


}