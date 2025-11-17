package com.example.bookshelf.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.data.RepositorioLibros
import kotlinx.coroutines.launch
import java.io.IOException

class VistaModeloLibrero(
    private val repositorioLibros: RepositorioLibros
) : ViewModel() {

    var estadoUi: EstadoUiLibrero by mutableStateOf(EstadoUiLibrero.Cargando)
        private set

    init {
        cargarLibros("jazz+history")
    }

    fun cargarLibros(consulta: String) {
        estadoUi = EstadoUiLibrero.Cargando
        viewModelScope.launch {
            estadoUi = try {
                val listaLibros = repositorioLibros.obtenerLibros(consulta)
                EstadoUiLibrero.Exito(listaLibros)
            } catch (excepcion: IOException) {
                EstadoUiLibrero.Error
            } catch (excepcion: Exception) {
                EstadoUiLibrero.Error
            }
        }
    }
}
