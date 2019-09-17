package domain

import domain.exception.DeathCharacterException

class NoneHealthState() : HealthState {
    override fun decreaseHealthIn(damage: Int, character: Character) {
        throw DeathCharacterException()
    }

    override fun increaseHealthIn(damage: Int, character: Character) {
        throw DeathCharacterException()
    }

    override fun healthAmount(): Float {
        return 0f
    }

    override fun isAlive(): Boolean {
        return false
    }

}
