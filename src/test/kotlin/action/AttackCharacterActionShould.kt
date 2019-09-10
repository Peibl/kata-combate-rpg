package action

import domain.RPGCharacter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import repository.RPGCharacters


internal class AttackCharacterActionShould {
    var characters = RPGCharacters()
    private val SOME_LEVEL = 1
    private val SOME_DAMAGE = 50
    @Before
    fun setUp() {
        this.characters = RPGCharacters()
    }

    @Test
    fun `decrease health from victim in indicate damage`() {
        val attacker = givenAttackerCharacter()
        val victim = givenACharacterForAttack()

        AttackCharacter(characters).execute(attacker.id, victim.id, SOME_DAMAGE)

        val expectedHealth = (1000f - SOME_DAMAGE)
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }

    @Test
    fun `decrease 50% of damage if victim level is 5 or more levels above the attacker`() {
        val attacker = givenCharacterWithLevel(6)
        val victim = givenCharacterWithLevel(15)

        var damage = 100;
        AttackCharacter(characters).execute(attacker.id, victim.id, damage)

        val expectedHealth = (1000f - (damage / 2))
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }

    @Test
    fun `increase damage in 50% if the attacked has 5 or less levels below the attacker's level`() {
        val attacker = givenCharacterWithLevel(15)
        val victim = givenCharacterWithLevel(6)

        var damage = 100;
        AttackCharacter(characters).execute(attacker.id, victim.id, damage)

        val expectedHealth = (1000f - (damage + (damage / 2)))
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }

    @Test
    fun `kill a character if the damage is greater than health`() {
        val attacker = givenAttackerCharacter()
        val victim = givenACharacterForAttack()

        val damage = 1500
        AttackCharacter(characters).execute(attacker.id, victim.id, damage)

        Assert.assertEquals(0f, victim.healthAmount())
        Assert.assertFalse(victim.isAlive())
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if character attacks itself`() {
        val victim = givenACharacterForAttack()

        AttackCharacter(characters).execute(victim.id, victim.id, SOME_DAMAGE)

    }

    private fun givenACharacterForAttack(): RPGCharacter {
        val character = RPGCharacter(SOME_LEVEL)
        this.characters.add(character)
        return character
    }

    private fun givenAttackerCharacter(): RPGCharacter {
        val character = RPGCharacter(SOME_LEVEL)
        this.characters.add(character)
        return character
    }

    private fun givenCharacterWithLevel(level: Int): RPGCharacter {
        val character = RPGCharacter(level)
        this.characters.add(character)
        return character
    }


}
