package infrastructure

import domain.Thing

interface Things {
    fun findById(id: Int): Thing
    fun add(thing: Thing)
}