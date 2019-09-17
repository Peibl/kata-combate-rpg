package domain

class Character(
    var level: Int,
    var position: Int,
    var attackType: AttackType,
    val guilds: MutableList<Guild>,
    var health: HealthState
) : Gremiable, Attackable {

    var id: Int = 0

    fun increaseHealthIn(health: Int) {
        this.health.increaseHealthIn(health, this)
    }

    fun healthAmount(): Float {
        return this.health.healthAmount()
    }

    fun isAlive(): Boolean {
        return this.health.isAlive()
    }

    override fun addGuild(guild: Guild) {
        this.guilds.add(guild)
    }

    override fun removeGuild(guild: Guild) {
        this.guilds.remove(guild)
    }

    override fun containsGuild(guild: Guild) = this.guilds.contains(guild)


    override fun shareGuildWith(gremiable: Gremiable): Boolean {
        return this.guilds.filter { gremiable.containsGuild(it) }.isNotEmpty()
    }

    override fun receiveDamage(damage: Int) {
        this.health.decreaseHealthIn(damage, this)
    }
}
