package domain

import java.lang.RuntimeException

class RPGCharacter(var health: Int, var level: Int, var alive: Boolean, var id: Int = 0) {
    val INITIAL_HEALTH = 1000
    fun decreaseHealthIn(damage: Int) {

        if (this.health >= damage) {
            this.health -= damage
        } else {
            this.health = 0
            this.alive = false
        }
    }

    fun increaseHealthIn(health: Int) {
        if (!alive) {
            throw RuntimeException()
        }
        if (this.health == 1000) {
            throw RuntimeException()
        }
        this.health += health
    }

}
