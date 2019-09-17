package action

import CharacterBuilder.Companion.aCharacter
import domain.*
import domain.exception.DeathCharacterException
import domain.exception.SameGuildException
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import infrastructure.InMemoryCharacters
import kotlin.test.assertTrue


internal class AttackCharacterActionShould {
    @Test
    fun `decrease health from victim in indicate damage`() {
        val attacker = aCharacter().build()
        val victim = aCharacter().build()
        this.characters.add(attacker)
        this.characters.add(victim)

        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)

        val expectedHealth = (1000f - SOME_DAMAGE)
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }

    @Test
    fun `decrease 50% of damage if victim level is 5 or more levels above the attacker`() {
        val attacker = aCharacter().withLevel(6).build()
        val victim = aCharacter().withLevel(15).build()
        this.characters.add(attacker)
        this.characters.add(victim)

        var damage = 100;
        AttackCharacterAction(characters).execute(attacker.id, victim.id, damage)

        val expectedHealth = (1000f - (damage / 2))
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }

    @Test
    fun `increase damage in 50% if the attacked has 5 or less levels below the attacker's level`() {
        val attacker = aCharacter().withLevel(15).build()
        val victim = aCharacter().withLevel(6).build()
        this.characters.add(attacker)
        this.characters.add(victim)

        var damage = 100;
        AttackCharacterAction(characters).execute(attacker.id, victim.id, damage)

        val expectedHealth = (1000f - (damage + (damage / 2)))
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }

    @Test
    fun `kill a character if the damage is greater than health`() {
        val attacker = aCharacter().build()
        val victim = aCharacter().build()
        this.characters.add(attacker)
        this.characters.add(victim)

        val damage = 1500
        AttackCharacterAction(characters).execute(attacker.id, victim.id, damage)

        Assert.assertEquals(0f, victim.healthAmount())
        Assert.assertFalse(victim.isAlive())
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `fail if character attacks itself`() {
        val victim = aCharacter().build()
        this.characters.add(victim)
        AttackCharacterAction(characters).execute(victim.id, victim.id, SOME_DAMAGE)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `failed if victim is out of range of melee attacker`() {
        val attacker = aCharacter().positioned(0).withAttackType(Melee()).build()
        val victim = aCharacter().positioned(15).withAttackType(SOME_ATTACK_TYPE).build()
        this.characters.add(attacker)
        this.characters.add(victim)

        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)

        val expectedHealth = (1000f - SOME_DAMAGE)
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }

    @Test(expected = UnsupportedOperationException::class)
    fun `failed if victim is out of range of ranged attacker`() {
        val attacker = aCharacter().positioned(0).withAttackType(Ranged()).build()
        val victim = aCharacter().positioned(50).withAttackType(SOME_ATTACK_TYPE).build()
        this.characters.add(attacker)
        this.characters.add(victim)

        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)

        val expectedHealth = (1000f - SOME_DAMAGE)
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }


    @Test(expected = SameGuildException::class)
    fun `fail if characters has the same guild`() {
        val attacker = aCharacter().withGuilds(mutableListOf(GUILDS.RED_GUILD)).build()
        val victim = aCharacter().withGuilds(mutableListOf(GUILDS.RED_GUILD)).build()
        this.characters.add(attacker)
        this.characters.add(victim)

        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)
    }

    @Test()
    fun `not fail if characters havent guilds`() {
        val attacker = aCharacter().withGuilds(mutableListOf()).build()
        val victim = aCharacter().withGuilds(mutableListOf()).build()
        this.characters.add(attacker)
        this.characters.add(victim)

        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)
    }

    @Test()
    fun `not fail if both characters have different guild`() {
        val attacker = aCharacter().withGuilds(mutableListOf(GUILDS.RED_GUILD)).build()
        val victim = aCharacter().withGuilds(mutableListOf(GUILDS.BLUE_GUILD)).build()
        this.characters.add(attacker)
        this.characters.add(victim)

        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)
    }

    @Test(expected = DeathCharacterException::class)
    fun `fail if victim is dead`() {
        val attacker = aCharacter().build()
        val victim = aCharacter().withHealth(NoneHealthState()).build()
        this.characters.add(attacker)
        this.characters.add(victim)

        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)
    }

    @Test
    fun `decrease health from victim in indicate damage after two attacks`() {
        val attacker = aCharacter().build()
        val victim = aCharacter().build()
        this.characters.add(attacker)
        this.characters.add(victim)

        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)
        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)

        val expectedHealth = (1000f - SOME_DAMAGE * 2)
        Assert.assertEquals(expectedHealth, victim.healthAmount())
    }

    @Test(expected = DeathCharacterException::class)
    fun `kill victim after two attacks`() {
        val attacker = aCharacter().build()
        val victim = aCharacter().withHealth(NoneHealthState()).build()
        this.characters.add(attacker)
        this.characters.add(victim)

        AttackCharacterAction(characters).execute(attacker.id, victim.id, SOME_DAMAGE)
        AttackCharacterAction(characters).execute(attacker.id, victim.id, (victim.healthAmount() + 500).toInt())

        Assert.assertFalse(victim.isAlive())
    }


    private val SOME_ATTACK_TYPE: AttackType = Melee()
    var characters = InMemoryCharacters()
    private val SOME_DAMAGE = 50
}
