package domain

class Character(
    var level: Int,
    var position: Int,
    var attackType: AttackType,
    var guilds: MutableList<Guild>,
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

    fun addGuild(guild: Guild) {
        this.guilds.add(guild)
    }

    fun removeGuild(guild: Guild) {
        this.guilds.remove(guild)
    }
}
