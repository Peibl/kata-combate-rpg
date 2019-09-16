package domain

enum class GUILDS(val id: Int) : Guild {
    NEUTRAL_GUILD(0) {
        override fun shareGuild(character: Character): Boolean {
            return false
        }
    },
    RED_GUILD(1),
    BLUE_GUILD(2);

    override fun shareGuild(character: Character): Boolean {
        return !character.guilds.contains(this)
    }

}