import heater.Heater
import pump.Pump

class CoffeeMaker(
    private val heater: Heater,
    private val pump: Pump
) {

    fun brew() {
        println("DEBUG: heater in maker ${heater.hashCode()}")
        heater.on()
        pump.pump()
        println(" [_]P coffee! [_]P ")
        heater.off()
        println("Coffee Served from maker id ${this.hashCode()}")
    }
}