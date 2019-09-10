package domain

class NoFaction(override var id: Int = 0) : Faction {
    override fun canAttack(victim: Character): Boolean {
        return true
    }
}