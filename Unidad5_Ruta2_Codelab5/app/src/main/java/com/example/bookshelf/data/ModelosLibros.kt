package com.example.bookshelf.data

import com.google.gson.annotations.SerializedName

// Respuesta de https://www.googleapis.com/books/v1/volumes?q=jazz+history
data class RespuestaLibros(
    val items: List<Volumen>?
)

data class Volumen(
    val id: String,
    @SerializedName("volumeInfo")
    val informacionVolumen: InformacionVolumen?
)

data class InformacionVolumen(
    @SerializedName("imageLinks")
    val enlacesImagenes: EnlacesImagenes?
)

data class EnlacesImagenes(
    @SerializedName("thumbnail")
    val miniatura: String?
)

// Modelo simple que usará la IU
data class Libro(
    val id: String,
    val urlMiniatura: String
)