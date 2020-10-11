package heater

interface Heater {
    fun on()
    fun off()
    fun isHot(): Boolean
}