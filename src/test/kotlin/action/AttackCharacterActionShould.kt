package action

import domain.Healthable
import domain.RPGCharacter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.RPGCharacters


internal class AttackCharacterActionShould {
    var characters = RPGCharacters()
    private val VICTIM_ID = 1
    private val SOME_LEVEL = 1
    private val SOME_DAMAGE = 50
    @Before
    fun setUp() {
        this.characters = RPGCharacters()
    }

    @Test
    fun `decrease health from victim in indicate damage`() {
        val victim: Healthable = givenACharacterForAttackWith(VICTIM_ID)

        AttackCharacter(characters).execute(VICTIM_ID, SOME_DAMAGE)

        val expectedHealth = (1000f - SOME_DAMAGE)
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }


    @Test
    fun `kill a character if the damage is greater than health `() {
        val victim: Healthable = givenACharacterForAttackWith(VICTIM_ID)

        val damage = 1500
        AttackCharacter(characters).execute(VICTIM_ID, damage)

        Assert.assertEquals(0f, victim.healthAmount())
        Assert.assertFalse(victim.isAlive())
    }


    private fun givenACharacterForAttackWith(id: Int): RPGCharacter {
        val victim = RPGCharacter(SOME_LEVEL, id)
        this.characters.add(victim)
        return victim
    }


}
