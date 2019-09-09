package action

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.RPGCharacters


internal class AttackCharacterActionShould {
    var repo = RPGCharacters()
    val SOME_AGGRESSOR_ID = 5
    @Before
    fun setUp() {
        this.repo = RPGCharacters()
    }

    @Test
    fun `decrease health from victim in 50`() {
        val victim = CreateCharacter(repo).execute()

        val damage = 50
        AttackCharacter(repo).execute(SOME_AGGRESSOR_ID, victim.id, damage)

        Assert.assertEquals(950, victim.health)
    }
}