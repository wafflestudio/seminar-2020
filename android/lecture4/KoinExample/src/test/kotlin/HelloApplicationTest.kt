import heater.Heater
import heater.HeaterImpl
import org.junit.Rule
import org.junit.Test
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.mockito.Mockito
import pump.Pump
import pump.PumpImpl
import kotlin.test.assertEquals

class HelloApplicationTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(coffeeModule)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz -> Mockito.mock(clazz.java) }

    @Test
    fun `heater works`() {
        val heater: Heater = HeaterImpl()
        heater.on()
        assertEquals(heater.isHot(), true)
        heater.off()
        assertEquals(heater.isHot(), false)
    }

    @Test
    fun `pump works`() {
        val mockHeater = Mockito.mock(Heater::class.java)

        Mockito.`when`(mockHeater.isHot()).thenReturn(false).thenReturn(true)
        val pump: Pump = PumpImpl(mockHeater)

        assertEquals(pump.pump(), false)
        assertEquals(pump.pump(), true)
    }
}