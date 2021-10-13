package cat.copernic.jmendezv

import java.io.IOException
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Implementació i tests de tota mena
 */

data class Point(val x: Double, val y: Double)

/*
* Índice de masa corporal
*
* imc = weight / height^2
* */
fun imc(weight: Double, height: Double): Double = weight / height.pow(2.0)

/*
* https://en.wikipedia.org/wiki/Quadratic_equation
*
* (-b ± sqrt(b^2 - 4ac)) / 2a
* */
fun secondDegreeEquation(a: Double, b: Double, c: Double): Pair<Double, Double> =
    Pair((-b + sqrt(b.pow(2) - 4 * a * c)) / 2 * a, (-b - sqrt(b.pow(2) - 4 * a * c)) / 2 * a)


/*
* Cálculo de la distancia entre dos puntos
*
* distance = √[(x2 – x1)^2 +(y2 – y1)^2]
* */
fun distance(p1: Point, p2: Point): Double = sqrt(((p2.x - p1.x).pow(2) + (p2.y - p1.y).pow(2)))

/*
* Cáculo de la pendiente de una recta
*
* slope = (y2 – y1) / (x2 – x1)
* */
fun slope(p1: Point, p2: Point): Double = (p2.y - p1.y) / (p2.x - p1.x)

/*
* Cálculo del punto medio de una recta
*
* midpoint = ((x1+x2)/2, (y1+y2)/2)
* */
fun midPoint(p1: Point, p2: Point): Point = Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2)
fun main() {
    println(midPoint(Point(4.0,5.0),Point(2.0,3.0)))
}
fun displayScore(score: Double) {
    val roundedScore = floor(score * 100) / 100
    when (roundedScore) {
        in 0.0..4.99 -> println("No supera")
        in 5.0..5.99 -> println("Supera")
        in 6.0..6.99 -> println("Bien")
        in 7.0..8.99 -> println("Notable")
        in 9.0..10.0 -> println("Excel·lent")
        else -> println("Nota invalida")
    }
}

/*
* Encuentra el menor y mayor
*
* [2,3,1,4,7,6,5] = (1,7)
* [] = IllegalArgumentException
* */
fun findMinAndMax(list: List<Int>): Pair<Int, Int> = if (list.isNotEmpty()) Pair(
    list.sorted().first(),
    list.sorted().last()
) else throw IllegalArgumentException("Esta vacio")

/*
*
* Cálculo del punto más cercano a point. points es una lista de tipo Point
*
* */
fun closest(point: Point, vararg points: Point): Point {
        var puntoMasCercano: Point = points[0]
        for (i in points) {
            if (distance(point, puntoMasCercano) >= distance(point, i)) {
                puntoMasCercano = i
            }
        }

        return puntoMasCercano

}
