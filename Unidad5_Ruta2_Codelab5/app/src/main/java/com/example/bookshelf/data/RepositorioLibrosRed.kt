package com.example.bookshelf.data

class RepositorioLibrosRed(
    private val servicioApiLibros: ServicioApiLibros
) : RepositorioLibros {

    override suspend fun obtenerLibros(consulta: String): List<Libro> {
        // 1. Primera solicitud: buscar libros
        val respuesta = servicioApiLibros.buscarVolumenes(consulta)

        val listaIds = respuesta.items?.map { it.id } ?: emptyList()

        // 2. Por cada id, pedimos el volumen individual (una detrás de otra en la misma corrutina)
        val listaVolumenes = listaIds.map { id ->
            servicioApiLibros.obtenerVolumen(id)
        }

        // 3. Extraemos la URL de la miniatura
        return listaVolumenes.mapNotNull { volumen ->
            val miniatura = volumen.informacionVolumen?.enlacesImagenes?.miniatura
            if (miniatura != null) {
                // Cambiamos http -> https para que se muestren las imágenes
                val urlSegura = miniatura.replace("http://", "https://")
                Libro(id = volumen.id, urlMiniatura = urlSegura)
            } else {
                null
            }
        }
    }
}
