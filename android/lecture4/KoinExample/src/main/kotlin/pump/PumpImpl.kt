package pump

import heater.Heater
import heater.HeaterImpl
import pump.Pump

class PumpImpl: Pump {

    private var heater: Heater

    constructor(heater: Heater) {
        this.heater = heater
    }
    override fun pump(): Boolean {
        println("DEBUG: heater in pump ${heater.hashCode()}")
        if (heater.isHot()) {
            println("Pump with Hot Heater!")
            return true
        } else {
            println("Cannot pump with cold heater...")
            return false
        }
    }
}