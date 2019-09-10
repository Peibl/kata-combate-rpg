package domain

class NoneHealth(character: RPGCharacter) : Healthable {
    override fun decreaseHealthIn(damage: Int) {
        throw RuntimeException()
    }

    override fun increaseHealthIn(damage: Int) {
        throw RuntimeException()
    }

    override fun healthAmount(): Float {
        return 0f
    }

    override fun isAlive(): Boolean {
        return false
    }

}
