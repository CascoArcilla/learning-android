package com.cascoArcilla.courseadroid.herosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.databinding.ActivityHeroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroListActivity : AppCompatActivity() {
    private lateinit var heroListBinding: ActivityHeroListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        heroListBinding = ActivityHeroListBinding.inflate(layoutInflater)
        setContentView(heroListBinding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        heroListBinding.svHeroApp.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchHero(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun searchHero(query: String) {
        CoroutineScope(Dispatchers.IO).launch { // el CoroutineScope es para hacer una proceso en algun hilo, todo lo de las llaves se hara en un hilo secundario
            val myResponse: Response<HeroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperHeroes(query)

            if (myResponse.isSuccessful) {
                val response: HeroDataResponse? = myResponse.body()

                if (response != null) {
                    Log.i("hero", response.toString())
                }

                Log.i("hero", "Llamada de api exitosa")
            } else {
                Log.i("hero", "Erro al llamar a la API")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}