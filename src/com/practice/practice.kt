package com.practice

fun main(args: Array<String>) {
    println("Kotlin 연습입니다!")

    val rand = Math.random()
    println("Random Seed = $rand\n")

    // when 문
    val price = 100 + rand.toInt()

    when (price) {
        100 -> println("100")
        200 -> println("200")
        else -> println("Not matched")
    }

    // 함수
    val result = sumPrice(100, 200)
    println("sumPrice(100, 200) = $result\n")
}

fun sumPrice(price1: Int, price2: Int): Int = price1 + price2

fun sumPrice2(price1: Int, price2: Int): Int {
    val price = price1 + price2
    return price
}