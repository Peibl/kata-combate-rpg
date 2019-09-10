package domain

interface Healthable {
    fun decreaseHealthIn(damage: Int)
    fun increaseHealthIn(damage: Int)
    fun healthAmount(): Float;
    fun isAlive(): Boolean
}
