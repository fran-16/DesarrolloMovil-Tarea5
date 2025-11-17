package com.example.bookshelf.ui

import com.example.bookshelf.data.Libro

sealed interface EstadoUiLibrero {
    object Cargando : EstadoUiLibrero
    data class Exito(val listaLibros: List<Libro>) : EstadoUiLibrero
    object Error : EstadoUiLibrero
}
