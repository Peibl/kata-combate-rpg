import action.AttackCharacter
import action.CreateCharacter
import org.junit.Assert
import org.junit.Test
import repository.RPGCharacters
import javax.xml.stream.events.Characters

class Test {
    val INITIAL_HEALTH = 1000
    val INITIAL_LEVEL = 1
    @Test
    fun `create character`() {
        val createdCharacter = CreateCharacter().execute()
        Assert.assertEquals(INITIAL_HEALTH, createdCharacter.health)
        Assert.assertEquals(INITIAL_LEVEL, createdCharacter.level)
        Assert.assertTrue(createdCharacter.alive)
    }

    @Test
    fun `character attacks another and it decrease health in 50`() {
        val victim = CreateCharacter().execute()
        val repo = RPGCharacters()
        val damage = 50
        val toId = 2
        AttackCharacter(repo).execute(toId, damage)


        Assert.assertEquals(950, victim.health)
    }


}