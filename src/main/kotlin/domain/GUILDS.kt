package domain

enum class GUILDS(val id: Int) : Guild {
    NEUTRAL_GUILD(0) {
        override fun canAttack(victim: Character): Boolean {
            return true
        }
    },
    RED_GUILD(1) {
        override fun canAttack(character: Character): Boolean {
            return !character.guilds.contains(this)
        }
    },
    BLUE_GUILD(2) {
        override fun canAttack(character: Character): Boolean {
            return !character.guilds.contains(this)
        }
    };


}