package domain

interface Healthable {
    fun decreaseHealthIn(damage: Int, character: Character)
    fun increaseHealthIn(damage: Int, character: Character)
    fun healthAmount(): Float;
    fun isAlive(): Boolean
}
