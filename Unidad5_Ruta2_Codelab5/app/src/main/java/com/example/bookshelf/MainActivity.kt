package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.data.ModuloRed
import com.example.bookshelf.data.RepositorioLibrosRed
import com.example.bookshelf.ui.AplicacionLibrero
import com.example.bookshelf.ui.EstadoUiLibrero
import com.example.bookshelf.ui.FabricaVistaModeloLibrero
import com.example.bookshelf.ui.VistaModeloLibrero
import com.example.bookshelf.ui.theme.BookshelfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repositorioLibros = RepositorioLibrosRed(ModuloRed.servicioApiLibros)

        setContent {
            BookshelfTheme {
                val vistaModeloLibrero: VistaModeloLibrero = viewModel(
                    factory = FabricaVistaModeloLibrero(repositorioLibros)
                )

                val estadoUi: EstadoUiLibrero = vistaModeloLibrero.estadoUi

                AplicacionLibrero(estadoUi = estadoUi)
            }
        }
    }
}
