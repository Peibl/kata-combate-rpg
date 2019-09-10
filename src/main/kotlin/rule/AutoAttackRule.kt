package rule

class AutoAttackRule(var fromId: Int, var toId: Int) : Rule {
    override fun verify() {
        if (fromId === toId) {
            throw UnsupportedOperationException()
        }
    }
}