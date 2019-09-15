package infrastructure

import domain.GUILDS
import domain.Guild

class InMemoryGuilds : Guilds {

    override fun findById(id: Int): Guild {
        return GUILDS.values().filter { it.id == id }[0]
    }
}