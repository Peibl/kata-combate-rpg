package domain

interface Gremiable {
    fun addGuild(guild: Guild)
    fun removeGuild(guild: Guild)
    fun containsGuild(guild: Guild): Boolean
    fun shareGuildWith(gremiable: Gremiable): Boolean
}
