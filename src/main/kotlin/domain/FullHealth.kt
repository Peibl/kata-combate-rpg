package domain

import java.lang.UnsupportedOperationException

class FullHealth() : Healthable {
    override fun decreaseHealthIn(damage: Int, character: Character) {
        if (1000f - damage <= 0) {
            character.health = ZeroHealth()
        } else {
            character.health = Health(1000f - damage)
        }
    }

    override fun increaseHealthIn(damage: Int, character: Character) {
        throw UnsupportedOperationException()
    }

    override fun healthAmount(): Float {
        return 1000f
    }

    override fun isAlive(): Boolean {
        return true
    }

}
