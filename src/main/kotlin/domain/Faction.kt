package domain

interface Faction {
    abstract fun canAttack(victim: Character): Boolean
    var id: Int;
}