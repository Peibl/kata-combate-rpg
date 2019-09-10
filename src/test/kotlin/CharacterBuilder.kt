import domain.AttackType
import domain.Character
import domain.Melee

class CharacterBuilder private constructor() {
    private var id: Int = 1
    private var level: Int = 1
    private var position: Int = 0
    private var attackType: AttackType = Melee()


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

    fun build(): Character {
        return Character(this.level, this.position, this.attackType)
    }

    companion object {
        fun aCharacter(): CharacterBuilder {
            return CharacterBuilder()
        }
    }
}