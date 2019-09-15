package domain

class Character(
    var level: Int,
    var position: Int,
    var attackType: AttackType,
    var factions: MutableList<Faction>,
    var health: Healthable
) {
    var id: Int = 0
    fun decreaseHealthIn(damage: Int) {
        this.health.decreaseHealthIn(damage, this)
    }

    fun increaseHealthIn(health: Int) {
        this.health.increaseHealthIn(health, this)
    }

    fun healthAmount(): Float {
        return this.health.healthAmount()
    }

    fun isAlive(): Boolean {
        return this.health.isAlive()
    }

    fun addFaction(faction: Faction) {
        this.factions.add(faction)
    }
}
