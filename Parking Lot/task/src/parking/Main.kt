package parking

import java.util.*

data class Car(val regNumber: String, val color: String) {
    override fun toString(): String {
        return "$regNumber $color"
    }
}

fun main() {
    val menu = Menu()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        when (scanner.next()) {
            "create" -> menu.create(scanner.nextInt())
            "status" -> menu.status()
            "park" -> menu.park(Car(scanner.next(), scanner.next()))
            "leave" -> menu.leave(scanner.nextInt())
            "reg_by_color" -> menu.regByColor(scanner.next())
            "spot_by_color" -> menu.spotByColor(scanner.next())
            "spot_by_reg" -> menu.spotByReg(scanner.next())
            "exit" -> break
        }
    }
}
