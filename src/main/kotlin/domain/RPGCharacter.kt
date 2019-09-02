package domain

class RPGCharacter(var health: Int, var level: Int, var alive: Boolean, var id: Int = 0) {
    fun decreaseHealthIn(damage: Int) {

        if (this.health >= damage) {
            this.health -= damage
        } else {
            this.health=0
            this.alive=false
        }
    }

}
