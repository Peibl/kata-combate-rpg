package domain

class Health(var health: Float, var character: Character) : Healthable {
    override fun decreaseHealthIn(damage: Int) {
        if (health - damage <= 0) {
            character.health = NoneHealth(character)
        } else {
            character.health = Health(health - damage, character)
        }
    }

    override fun increaseHealthIn(damage: Int) {
        if (health + damage > 1000) {
            character.health = FullHealth(character)
        } else {
            character.health = Health(health + damage, character)
        }
    }

    override fun healthAmount(): Float {
        return health
    }
    override fun isAlive(): Boolean {
        return true
    }

}
