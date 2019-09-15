package action

import domain.Character
import domain.FullHealth
import domain.Melee
import infrastructure.Characters
import infrastructure.CharactersInMemory

class CreateCharacterAction(var characters: Characters) {
    var INITIAL_LEVEL = 1
    val INITIAL_POSITION = 0
    val INITIAL_ATTACK_TYPE = Melee()
    fun execute(): Character {
        val rpgCharacter =
            Character(INITIAL_LEVEL, INITIAL_POSITION, INITIAL_ATTACK_TYPE, mutableListOf(), FullHealth())
        this.characters.add(rpgCharacter)
        return rpgCharacter;
    }


}