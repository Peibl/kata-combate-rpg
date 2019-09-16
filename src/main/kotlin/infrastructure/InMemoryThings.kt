package infrastructure

import domain.Thing

class InMemoryThings : Things {
    private var id = 1;
    private val InMemoryCharacters = mutableListOf<Thing>()
    override fun findById(id: Int): Thing {
        return this.InMemoryCharacters.filter { it.id == id }.single()
    }

    override fun add(thing: Thing) {
        thing.id = this.id++
        this.InMemoryCharacters.add(thing)
    }

}