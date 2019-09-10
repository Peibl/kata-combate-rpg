package domain

class Damage(var value: Int) {
    fun recalculate(victim: Character, attacker: Character) {
        if ((victim.level - attacker.level) >= 5) {
            value /= 2
        }
        if ((attacker.level - victim.level) >= 5) {
            value += (value / 2)
        }
    }

}