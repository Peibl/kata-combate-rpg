import action.AttackCharacter
import action.CreateCharacter
import action.CureCharacter
import domain.RPGCharacter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.RPGCharacters

class Test {
    val INITIAL_HEALTH = 1000
    val INITIAL_LEVEL = 1
    var repo = RPGCharacters()
    @Before
    fun init() {
        this.repo = RPGCharacters()

    }

    @Test
    fun `create character`() {
        val createdCharacter = CreateCharacter(repo).execute()
        Assert.assertEquals(INITIAL_HEALTH, createdCharacter.health)
        Assert.assertEquals(INITIAL_LEVEL, createdCharacter.level)
        Assert.assertTrue(createdCharacter.alive)
    }

    @Test
    fun `a character attacks another and it decrease health in 50`() {
        val victim = CreateCharacter(repo).execute()

        val damage = 50
        AttackCharacter(repo).execute(victim.id, damage)

        Assert.assertEquals(950, victim.health)
    }

    @Test
    fun `a character attacks another and kill it`() {
        val victim = CreateCharacter(repo).execute()

        val damage = 1050
        AttackCharacter(repo).execute(victim.id, damage)

        Assert.assertEquals(0, victim.health)
        Assert.assertFalse(victim.alive)
    }


    @Test
    fun `a character cure another in 50`() {
        val character = RPGCharacter(950, 1, true, 1)
        this.repo.add(character)

        CureCharacter(repo).execute(character.id,50)

        Assert.assertEquals(1000, character.health)
    }

}