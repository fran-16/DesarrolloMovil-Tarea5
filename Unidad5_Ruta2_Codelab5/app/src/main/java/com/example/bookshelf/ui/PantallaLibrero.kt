package com.example.bookshelf.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookshelf.R
import com.example.bookshelf.data.Libro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AplicacionLibrero(
    estadoUi: EstadoUiLibrero,
    modificador: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Bookshelf") }
            )
        },

        containerColor = colorResource(id = R.color.bs_background)
    ) { rellenoInterno ->
        Box(
            modifier = modificador
                .padding(rellenoInterno)
                .fillMaxSize()
                // Color del fondo de todo el contenido
                .background(colorResource(id = R.color.bs_background))
        ) {
            when (estadoUi) {
                is EstadoUiLibrero.Cargando -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is EstadoUiLibrero.Error -> {
                    Text(
                        text = "Error al cargar libros",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is EstadoUiLibrero.Exito -> {
                    CuadriculaLibros(
                        listaLibros = estadoUi.listaLibros,
                        modificador = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun CuadriculaLibros(
    listaLibros: List<Libro>,
    modificador: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modificador.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listaLibros, key = { it.id }) { libro ->
            PortadaLibro(libro = libro)
        }
    }
}

@Composable
fun PortadaLibro(libro: Libro) {
    AsyncImage(
        model = libro.urlMiniatura,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .aspectRatio(0.7f)
            .clip(RoundedCornerShape(6.dp))
    )
}
