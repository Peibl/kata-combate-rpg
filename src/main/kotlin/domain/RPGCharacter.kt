package domain

class RPGCharacter(var health: Int, var level: Int, var alive: Boolean, var id: Int = 0) {
    fun decreaseHealthIn(damage: Int) {
        this.health -= damage
    }

}
