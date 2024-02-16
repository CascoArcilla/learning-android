package com.cascoArcilla.courseadroid.herosapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    // con suspend nosotros adquirimos una forma asincrona para nuestra funcion que llamara a la api
    @GET("/api/3700905376812211/search/{name}") // Usamos @GET del retrofit2, ahi entre {} va el nombre que vamos a sustituir en de la url
    suspend fun getSuperHeroes(@Path("name") superHero: String): Response<HeroDataResponse> //usamos el @Path de retrofit para encontrar el nombre por el que vamos a sustituir
}