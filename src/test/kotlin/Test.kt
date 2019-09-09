import action.AttackCharacter
import action.CreateCharacter
import action.CureCharacter
import domain.RPGCharacter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.RPGCharacters
import java.lang.RuntimeException

class Test {

    val SOME_AGGRESSOR_ID = 5
    val SOME_CHARACTER_ID = 5555
    var repo = RPGCharacters()
    @Before
    fun init() {
        this.repo = RPGCharacters()
    }


    @Test
    fun `a character attacks another and it decrease health in 50`() {
        val victim = CreateCharacter(repo).execute()

        val damage = 50
        AttackCharacter(repo).execute(SOME_AGGRESSOR_ID, victim.id, damage)

        Assert.assertEquals(950, victim.health)
    }

    @Test
    fun `a character attacks another and kill it`() {
        val victim = CreateCharacter(repo).execute()

        val damage = 1050
        AttackCharacter(repo).execute(SOME_AGGRESSOR_ID, victim.id, damage)

        Assert.assertEquals(0, victim.health)
        Assert.assertFalse(victim.alive)
    }


    @Test(expected = RuntimeException::class)
    fun `a character cure another in 50`() {
        val character = RPGCharacter(950, 1, true, 1)
        this.repo.add(character)

        CureCharacter(repo).execute(SOME_CHARACTER_ID, character.id, 50)

        Assert.assertEquals(1000, character.health)
    }


    @Test
    fun `a character cant cure another with full health`() {
        val character = CreateCharacter(repo).execute()
        try {
            CureCharacter(repo).execute(character.id, character.id, 50)
            Assert.fail();
        } catch (e: RuntimeException) {
            Assert.assertTrue(true)
        }

        Assert.assertEquals(1000, character.health)
    }

    @Test(expected = RuntimeException::class)
    fun `a character try cure a dead character`() {
        val character = RPGCharacter(0, 1, false, 1)
        this.repo.add(character)
        CureCharacter(repo).execute(SOME_CHARACTER_ID, character.id, 50)
    }

    @Test(expected = RuntimeException::class)
    fun `a character attacks itself`() {
        val victim = CreateCharacter(repo).execute()
        val damage = 1050
        AttackCharacter(repo).execute(victim.id, victim.id, damage)
    }

    @Test()
    fun `a character cure itself in 50`() {
        val character = RPGCharacter(100, 1, true, 1)
        this.repo.add(character)
        CureCharacter(repo).execute(character.id, character.id, 50)
        Assert.assertEquals(150, character.health)
    }

    @Test()
    fun `xxx`() {
        val character = RPGCharacter(100, 1, true, 1)
        this.repo.add(character)
        CureCharacter(repo).execute(character.id, character.id, 50)
        Assert.assertEquals(150, character.health)
    }
}