package domain

import java.lang.UnsupportedOperationException

class ZeroHealth() : Healthable {
    override fun decreaseHealthIn(damage: Int, character: Character) {
        throw UnsupportedOperationException()
    }

    override fun increaseHealthIn(damage: Int, character: Character) {
        throw UnsupportedOperationException()
    }

    override fun healthAmount(): Float {
        return 0f
    }

    override fun isAlive(): Boolean {
        return false
    }

}
