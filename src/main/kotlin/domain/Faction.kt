package domain

interface Faction {
    fun canAttack(victim: Character): Boolean
}