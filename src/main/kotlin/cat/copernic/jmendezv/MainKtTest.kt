package cat.copernic.jmendezv

import jdk.nashorn.internal.objects.NativeRegExp.test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.time.Duration
import java.util.stream.Stream
//import kotlin.test.assertFailsWith

internal class MainKtTest {

    @Test
    @DisplayName("test simple de imc")
    fun imcTest() {
        assertEquals(23.529411764705884, imc(68.0, 1.7))
    }

    @Test
    @DisplayName("test simple de distance")
    fun distanceTest() {
        assertEquals(4.47213595499958, distance(Point(2.0, 3.0), Point(4.0, 7.0)))
    }

    @ParameterizedTest
    @DisplayName("test con csvSource de imc")
    @CsvSource("1.0,1.0,1.0", "0.2222222222222222,2.0,3.0", "0.037037037037037035,3.0,9.0")
    fun imcTestPTCS(a: Double, b: Double, c: Double) {
        assertEquals(a, imc(b, c))
    }

    @ParameterizedTest
    @DisplayName("test con csvSource de secondDegreeEquation")
    @CsvSource("3.0,2.0,1.0,-5.0,6.0", "2.0,5.0,-1.0,7.0,-10.0", "2.0,2.0,-1.0,4.0,-4.0")
    fun secondDegreeEquationPTCS(a: Double, b: Double, c: Double, d: Double, e: Double) {
        assertEquals(Pair(a, b), secondDegreeEquation(c, d, e))
    }

    companion object {
        @JvmStatic
        fun provideParametersForimc(): Stream<Arguments> {
            return Stream.of(

                Arguments.of(1.0, 1.0, 1.0),
                Arguments.of(0.2222222222222222, 2.0, 3.0),
                Arguments.of(0.037037037037037035, 3.0, 9.0),
            )
        }

        @JvmStatic
        fun provideParametersForsecondDegreeEquation(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(3.0,2.0,1.0,-5.0,6.0),
                Arguments.of(2.0,5.0,-1.0,7.0,-10.0),
                Arguments.of(2.0,2.0,-1.0,4.0,-4.0),
            )
        }

        @BeforeAll
        @JvmStatic
        @DisplayName("Al principio del programa muestra por pantalla Inicio tests... ")
        fun init() {
            println("Inicio tests... ")
        }

        @AfterAll
        @JvmStatic
        @DisplayName("Al final del programa muestra por pantalla Inicio Final tests... ")
        fun end() {
            println("Final tests...")
        }
    }

    @ParameterizedTest
    @MethodSource("provideParametersForimc")
    @DisplayName("test con displayname de imc, en companion object podemos ver a que hace referencia en MethodSource")
    fun imcPTMS(a: Double, b: Double, c: Double) {
        assertEquals(a, imc(b, c))
    }

    @ParameterizedTest
    @MethodSource("provideParametersForsecondDegreeEquation")
    @DisplayName("test con displayname de secondDegreeEquation,en companion object podemos ver a que hace referencia en MethodSource")
    fun provideParametersForsecondDegreeEquationPTMS(a: Double, b: Double, c: Double, d: Double, e: Double) {
        assertEquals(Pair(a, b), secondDegreeEquation(c, d, e))
    }


    @ParameterizedTest
    @ValueSource(doubles = [3.0, 2.0, 5.0])
    @DisplayName("test de valueSource, sirve para pasar una array al test")
    fun closestPTVS(a: Double){
        assertEquals(Point(a,a), closest(Point(2.0,3.0),Point(3.0,3.0),Point(2.0,2.0),Point(5.0,5.0)))
    }

    @ParameterizedTest
    @ValueSource(doubles = [0.0, 2.0, 5.0])
    @DisplayName("test de valueSource, sirve para pasar una array al test")
    fun slopePTVS(a: Double){
        assertEquals(a, slope(Point(2.0,3.0),Point(3.0,3.0)))
    }

    @Test
    @DisplayName("test de timeOut de midPoint")
    fun midPointTTO() {
        val result =
            org.junit.jupiter.api.assertTimeout(Duration.ofMillis(100)) {
                assertEquals(Point(3.0,4.0),midPoint(Point(4.0,5.0),Point(2.0,3.0)))
            }
    }



    @BeforeEach
    @DisplayName("Al principio de cada test muestra por pantalla Inicio test ...")
    fun setUp() {
        println("Inicio test ...")
    }

    @AfterEach
    @DisplayName("Al final de cada test muestra por pantalla Final test...")
    fun tearDown() {
        println("Final test...")
    }


    @Test
    fun displayScoreTest() {
    }

    @Test
    fun findMinAndMaxTest() {
    }
/* No se importa por alguna razon
    @Test
    fun findMinAndMaxTestExcepciones() {
        assertFailsWith<IllegalArgumentException> {
            findMinAndMax(listOf())
        }
    }*/


}