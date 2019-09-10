package domain

class Character(var level: Int, var position: Int, var attackType: AttackType) : Healthable {
    var id: Int = 0
    var health: Healthable = FullHealth(this)

    override fun decreaseHealthIn(damage: Int) {
        this.health.decreaseHealthIn(damage)
    }

    override fun increaseHealthIn(health: Int) {
        this.health.increaseHealthIn(health)
    }

    override fun healthAmount(): Float {
        return this.health.healthAmount()
    }

    override fun isAlive(): Boolean {
        return this.health.isAlive()
    }

}
