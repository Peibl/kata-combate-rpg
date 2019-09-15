package infrastructure

import domain.Guild

interface Guilds {
    fun findById(id: Int): Guild
}