import action.AttackCharacter
import action.CreateCharacter
import org.junit.Assert
import org.junit.Test
import repository.RPGCharacters

class Test {
    val INITIAL_HEALTH = 1000
    val INITIAL_LEVEL = 1
    @Test
    fun `create character`() {
        val repo = RPGCharacters()
        val createdCharacter = CreateCharacter(repo).execute()
        Assert.assertEquals(INITIAL_HEALTH, createdCharacter.health)
        Assert.assertEquals(INITIAL_LEVEL, createdCharacter.level)
        Assert.assertTrue(createdCharacter.alive)
    }

    @Test
    fun `character attacks another and it decrease health in 50`() {
        val repo = RPGCharacters()
        val victim = CreateCharacter(repo).execute()
        val damage = 50
        AttackCharacter(repo).execute(victim.id, damage)


        Assert.assertEquals(950, victim.health)
    }


}