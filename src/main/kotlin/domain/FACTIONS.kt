package domain

enum class FACTIONS(id: Int) : Faction {
    NEUTRAL_FACTION(0) {

        override fun canAttack(victim: Character): Boolean {
            return true
        }
    },
    RED_FACTION(1) {
        override fun canAttack(character: Character): Boolean {
            return !character.factions.contains(this)
        }
    },
}