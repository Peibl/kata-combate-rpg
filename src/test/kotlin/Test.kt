class Test {

//    val SOME_AGGRESSOR_ID = 5
//
//    var repo = RPGCharacters()
//    @Before
//    fun init() {
//        this.repo = RPGCharacters()
//    }
//
//
//
//    @Test
//    fun `a character cant cure another with full health`() {
//        val character = CreateCharacter(repo).execute()
//        try {
//            CureCharacter(repo).execute(character.id, 50)
//            Assert.fail();
//        } catch (e: RuntimeException) {
//            Assert.assertTrue(true)
//        }
//
//        Assert.assertEquals(1000, character.health)
//    }
//
//    @Test(expected = RuntimeException::class)
//    fun `a character try cure a dead character`() {
//        val character = RPGCharacter(0, 1, false, 1)
//        this.repo.add(character)
//        CureCharacter(repo).execute( character.id, 50)
//    }
//
//    @Test(expected = RuntimeException::class)
//    fun `a character attacks itself`() {
//        val victim = CreateCharacter(repo).execute()
//        val damage = 1050
//        AttackCharacter(repo).execute(victim.id, victim.id, damage)
//    }
//
//    @Test()
//    fun `a character cure itself in 50`() {
//        val character = RPGCharacter(100, 1, true, 1)
//        this.repo.add(character)
//        CureCharacter(repo).execute( character.id, 50)
//        Assert.assertEquals(150, character.health)
//    }
//
//    @Test()
//    fun `xxx`() {
//        val character = RPGCharacter(100, 1, true, 1)
//        this.repo.add(character)
//        CureCharacter(repo).execute( character.id, 50)
//        Assert.assertEquals(150, character.health)
//    }
}