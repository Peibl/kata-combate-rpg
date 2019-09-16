import domain.*

class ThingBuilder private constructor() {
    private var health = 500;
    private var id = 1
    private var name = "name"

    fun id(id: Int): ThingBuilder {
        this.name = name
        return this
    }

    fun named(name: String): ThingBuilder {
        this.name = name
        return this
    }

    fun withHealth(health: Int): ThingBuilder {
        this.health = health
        return this
    }

    fun build(): Thing {
        return Thing(id, name, health)
    }

    companion object {
        fun aThing(): ThingBuilder {
            return ThingBuilder()
        }
    }
}