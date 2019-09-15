package domain

interface Guild {
    fun canAttack(victim: Character): Boolean
}