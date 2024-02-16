package com.cascoArcilla.courseadroid.herosapp

import com.google.gson.annotations.SerializedName // esto es como una manaera de leer los atributos de un json y usarlos para pasarlo al valor del parametro

data class HeroDataResponse(@SerializedName("response") val response: String)