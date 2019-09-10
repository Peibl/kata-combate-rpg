package domain

import java.lang.UnsupportedOperationException

class NoneHealth(character: RPGCharacter) : Healthable {
    override fun decreaseHealthIn(damage: Int) {
        throw UnsupportedOperationException()
    }

    override fun increaseHealthIn(damage: Int) {
        throw UnsupportedOperationException()
    }

    override fun healthAmount(): Float {
        return 0f
    }

    override fun isAlive(): Boolean {
        return false
    }

}
