package domain

class SomeFaction(override var id: Int = 1) : Faction {
    override fun canAttack(character: Character): Boolean {
        return id !== character.faction.id
    }
}