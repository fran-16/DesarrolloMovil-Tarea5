package com.example.bookshelf.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookshelf.data.RepositorioLibros

class FabricaVistaModeloLibrero(
    private val repositorioLibros: RepositorioLibros
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(claseModelo: Class<T>): T {
        if (claseModelo.isAssignableFrom(VistaModeloLibrero::class.java)) {
            return VistaModeloLibrero(repositorioLibros) as T
        }
        throw IllegalArgumentException("Clase ViewModel desconocida")
    }
}
