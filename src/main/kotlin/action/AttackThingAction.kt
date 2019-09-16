package action

import infrastructure.Characters
import infrastructure.Things

class AttackThingAction(val characters: Characters, val things: Things) {

    fun execute(characterId: Int, thingId: Int, damage: Int) {
        val character = this.characters.findById(characterId)
        val thing = things.findById(thingId)
        thing.receiveDamage(damage)
    }
}