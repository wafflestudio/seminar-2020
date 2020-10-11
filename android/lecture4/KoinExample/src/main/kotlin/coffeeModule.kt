import heater.Heater
import heater.HeaterImpl
import org.koin.dsl.bind
import org.koin.dsl.module
import pump.Pump
import pump.PumpImpl


val coffeeModule = module {
    factory { CoffeeShop() }
    scope<CoffeeShop> {
        scoped { HeaterImpl() } bind Heater::class
        scoped { PumpImpl(get()) } bind Pump::class
        scoped { CoffeeMaker(get(), get())}
    }
}