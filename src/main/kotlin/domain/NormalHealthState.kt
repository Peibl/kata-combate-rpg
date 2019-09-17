package domain

class NormalHealthState(val healthValue: Float) : HealthState {
    override fun decreaseHealthIn(damage: Int, character: Character) {
        if (healthValue - damage <= 0) {
            character.health = NoneHealthState()
        } else {
            character.health = NormalHealthState(healthValue - damage)
        }
    }

    override fun increaseHealthIn(damage: Int, character: Character) {
        if (healthValue + damage > 1000) {
            character.health = FullHealthState()
        } else {
            character.health = NormalHealthState(healthValue + damage)
        }
    }

    override fun healthAmount(): Float {
        return healthValue
    }

    override fun isAlive(): Boolean {
        return true
    }

}
