import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import org.koin.ext.scope


fun main(args: Array<String>) {
    val koin = startKoin {
        printLogger()
        modules(coffeeModule)
    }.koin

    val shop1 = koin.get<CoffeeShop>()
    val maker1_1 = shop1.scope.get<CoffeeMaker>()
    maker1_1.brew()

    val maker1_2 = shop1.scope.get<CoffeeMaker>()
    maker1_2.brew()


    val shop2 = koin.get<CoffeeShop>()
    val maker2 = shop2.scope.get<CoffeeMaker>()
    maker2.brew()
}