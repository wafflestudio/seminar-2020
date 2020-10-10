package heater

class NewHeaterImpl : Heater {
    private var hot = false
    override fun on() {
        println("New Heater ON!")
        hot = true
    }

    override fun off() {
       println("New Heater OFF!")
        hot = false
    }

    override fun isHot(): Boolean {
        return hot
    }
}