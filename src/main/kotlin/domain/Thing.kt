package domain

import domain.exception.ThingDestroyedException

class Thing(var id: Int, val name: String, var health: Int) {
    fun receiveDamage(damage: Int) {
        val newHealth = health - damage;
        if (newHealth < 0) {
            health = 0
            throw ThingDestroyedException()
        }
        health = newHealth
    }
}
