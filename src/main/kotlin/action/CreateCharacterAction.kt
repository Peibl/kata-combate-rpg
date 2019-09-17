package action

import domain.Character
import domain.FullHealthState
import domain.Melee
import infrastructure.Characters

class CreateCharacterAction(var characters: Characters) {
    private var INITIAL_LEVEL = 1
    private var INITIAL_POSITION = 0
    private val INITIAL_ATTACK_TYPE = Melee()
    fun execute(): Character {
        val rpgCharacter =
            Character(INITIAL_LEVEL, INITIAL_POSITION, INITIAL_ATTACK_TYPE, mutableListOf(), FullHealthState())
        this.characters.add(rpgCharacter)
        return rpgCharacter;
    }


}