package domain

class NormalHealthState(var health: Float) : HealthState {
    override fun decreaseHealthIn(damage: Int, character: Character) {
        if (health - damage <= 0) {
            character.health = NoneHealthState()
        } else {
            character.health = NormalHealthState(health - damage)
        }
    }

    override fun increaseHealthIn(damage: Int, character: Character) {
        if (health + damage > 1000) {
            character.health = FullHealthState()
        } else {
            character.health = NormalHealthState(health + damage)
        }
    }

    override fun healthAmount(): Float {
        return health
    }

    override fun isAlive(): Boolean {
        return true
    }

}
