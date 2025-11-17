package com.example.bookshelf.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL_BASE = "https://www.googleapis.com/books/v1/"

object ModuloRed {

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val servicioApiLibros: ServicioApiLibros by lazy {
        retrofit.create(ServicioApiLibros::class.java)
    }
}
