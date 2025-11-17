package com.example.bookshelf.data

interface RepositorioLibros {
    suspend fun obtenerLibros(consulta: String): List<Libro>
}
