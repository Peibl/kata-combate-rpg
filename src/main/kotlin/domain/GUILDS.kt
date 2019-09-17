package domain

enum class GUILDS(val id: Int) : Guild {
    RED_GUILD(1),
    BLUE_GUILD(2);

    override fun shareGuild(character: Character): Boolean {
        return !character.guilds.contains(this)
    }

}