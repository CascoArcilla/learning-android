package com.cascoArcilla.courseadroid.sintaxis

fun main(){
    val animals:MutableList<String> = mutableListOf("Perro", "Gato", "Pez", "Hamster")
    println(animals)
    animals.add(animals.size-1, "Perico")
    println(animals)
    animals.remove("Gato")
    println(animals)
}

fun listInsmutable(){
    // Listas
    val readOnly:List<String> = listOf("Perro", "Gato", "Pez", "Hamster")  // recordar que val es una constante

//    println(readOnly)
//    println(readOnly[2])
//    println(readOnly.first())
//    println(readOnly.last())
//    for (animal in readOnly){
//        println(animal)
//    }

    val example = readOnly.filter { it.contains("a") } // it es el elemento
    println(example)

    readOnly.forEach{ animal -> println(animal)}
}

fun arrasyClasss(){
    // Las listas al parecer no pueden aumentar o disminuir su size
    var weekDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")

    println(weekDays.size)

    weekDays.plus("Sabado")

    for ((index, day) in weekDays.withIndex()){
        println("$day $index")
    }
}