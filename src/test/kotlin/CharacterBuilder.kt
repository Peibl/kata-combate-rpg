import domain.*

class CharacterBuilder private constructor() {
    private var health: Healthable = FullHealth()
    private var id = 1
    private var level = 1
    private var position = 0
    private var attackType: AttackType = Melee()
    private var factions = mutableListOf<Faction>()

    fun withFaction(factions: MutableList<Faction>): CharacterBuilder {
        this.factions = factions
        return this
    }

    fun withLevel(level: Int): CharacterBuilder {
        this.level = level
        return this
    }

    fun positioned(position: Int): CharacterBuilder {
        this.position = position
        return this
    }

    fun withAttackType(attackType: AttackType): CharacterBuilder {
        this.attackType = attackType
        return this
    }

    fun withHealth(health: Healthable): CharacterBuilder {
        this.health = health
        return this
    }

    fun build(): Character {
        return Character(this.level, this.position, this.attackType, this.factions, this.health)
    }

    companion object {
        fun aCharacter(): CharacterBuilder {
            return CharacterBuilder()
        }
    }
}