package heater

import heater.Heater

class HeaterImpl : Heater {
    private var heaterOn = false
    override fun on() {
        println("heater.Heater Turn On")
        heaterOn = true
    }

    override fun off() {
        println("heater.Heater Turn Off")
        heaterOn = false
    }

    override fun isHot(): Boolean = heaterOn
}