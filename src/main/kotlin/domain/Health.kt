package domain

class Health(var health: Float) : Healthable {
    override fun decreaseHealthIn(damage: Int, character: Character) {
        if (health - damage <= 0) {
            character.health = ZeroHealth()
        } else {
            character.health = Health(health - damage)
        }
    }

    override fun increaseHealthIn(damage: Int, character: Character) {
        if (health + damage > 1000) {
            character.health = FullHealth()
        } else {
            character.health = Health(health + damage)
        }
    }

    override fun healthAmount(): Float {
        return health
    }

    override fun isAlive(): Boolean {
        return true
    }

}
