package com.example.bookshelf.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServicioApiLibros {

    // Busca libros por término
    @GET("volumes")
    suspend fun buscarVolumenes(
        @Query("q") consulta: String
    ): RespuestaLibros

    // Obtiene información detallada de un libro
    @GET("volumes/{id}")
    suspend fun obtenerVolumen(
        @Path("id") id: String
    ): Volumen
}
