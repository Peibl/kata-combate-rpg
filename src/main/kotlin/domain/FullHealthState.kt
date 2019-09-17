package domain

import domain.exception.CantCureFullHealthCharacterException

class FullHealthState() : HealthState {
    override fun decreaseHealthIn(damage: Int, character: Character) {
        if (1000f - damage <= 0) {
            character.health = NoneHealthState()
        } else {
            character.health = NormalHealthState(1000f - damage)
        }
    }

    override fun increaseHealthIn(damage: Int, character: Character) {
        throw CantCureFullHealthCharacterException()
    }

    override fun healthAmount(): Float {
        return 1000f
    }

    override fun isAlive(): Boolean {
        return true
    }

}
