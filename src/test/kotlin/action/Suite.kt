package action

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    AttackCharacterActionShould::class,
    CreateCharacterActionShould::class,
    CureCharacterActionShould::class,
    JoinGuildActionShould::class
)
class Suite {
}