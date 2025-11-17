package com.example.bookshelf.data

class RepositorioLibrosFalso : RepositorioLibros {
    override suspend fun obtenerLibros(consulta: String): List<Libro> {
        return listOf(
            Libro("1", "https://via.placeholder.com/150x200.png?text=Libro+1"),
            Libro("2", "https://via.placeholder.com/150x200.png?text=Libro+2"),
            Libro("3", "https://via.placeholder.com/150x200.png?text=Libro+3"),
            Libro("4", "https://via.placeholder.com/150x200.png?text=Libro+4"),
        )
    }
}
