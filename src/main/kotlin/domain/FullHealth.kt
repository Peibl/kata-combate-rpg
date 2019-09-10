package domain

import java.lang.UnsupportedOperationException

class FullHealth(var character: Character) : Healthable {


    override fun decreaseHealthIn(damage: Int) {
        if (1000f - damage <= 0) {
            character.health = NoneHealth(character)
        } else {
            character.health = Health(1000f - damage, character)
        }
    }

    override fun increaseHealthIn(damage: Int) {
        throw UnsupportedOperationException()
    }

    override fun healthAmount(): Float {
        return 1000f
    }

    override fun isAlive(): Boolean {
        return true
    }

}
