package com.cascoArcilla.courseadroid.sintaxis

fun main() {
//    var small:Int = 12
//    var another:Int = 10
//    var texto: String = "Gatos ${small+another}"
//    println(texto)
//    isMayor(22)
//    isMayor(18)
//    isMayor(17)

    var arr = listOf("apple", "bottle", 21, 25)
    val lista : List<Float> = listOf(23.2f, 24.5f)
    println(lista[0])
    println(lista[1])
    if (30f >= lista[0] && 30f <= lista[1]){
        println("yes")
    } else{
        println("nop")
    }
//    for(item in arr){
//        println(item)
//    }
//    var index = 0
//    while (index < arr.size){
//        println(arr[index])
//        index++
//    }

//    getMonth(3)
//    getMonth(23)
//    getMonth(58)
//    getMonth(18)

//    nulles()
}

fun nulles(){
    var name:String? = null

    //println(name!!.get(3)) Sabes que no hay null y siempre hay valor
    println(name?.get(3) ?: "Es nulo") //Sabes que puede haber null
}

fun sumar(numero: Int, numero2: Int): Int {
    return numero + numero2
}

fun sumarTexto(text1: String, text2: String): String {
    return text1 + " " + text2
}

fun isMayor(age: Int) {
    if (age >= 18) {
        println("Eres mayor de edad")
    } else {
        println("Eres menor de edad")
    }
}

fun getMonth(month: Int) {
    when (month) {
        1 -> println("Enero")
        2 -> println("Febrero")
        3 -> {
            println("Marzo")
            println("Mi cumpleaños")
        }

        4 -> println("Abril")
        5 -> println("Mayo")
        6 -> println("Agosto")
        7 -> println("Julio")
        8 -> {
            println("Junio")
            println("Viva yo")
        }

        9 -> println("Septiembre")
        10 -> println("Octubre")
        11 -> println("Noviembre")
        12 -> println("Diciembre")
        13, 14, 15 -> println("Orale ese no es un mes")
        in 16..17 -> println("¿De que te fumaste carnal? -_-")
        18 -> println("Super, numero de la serte")
        in 19..205 -> println("Super, mas numeros, ingresa mes valido.")
        else -> println("Ese mes no existe")
    }
}