package org.acs.uacm.puntodeventa.domain

import org.acs.uacm.puntodeventa.domain.constantes.Textos
import java.time.LocalDate

/**
 * Clase **LoteProducto**.
 *
 * Clase que registra lotes de un producto, lo que permite tener
 * productos con diferentes fechas de caducidad y sus existencias.
 *
 * Utiliza la clase [Producto] para representar las categorías
 * de los productos de una tienda.
 *
 * @author José Carlos Ascencio Navarro
 * @version 1.0.0
 * @see [Producto]
 */

data class LoteProducto (
    val id: String,
    val producto: Producto,
    val fechaCaducidad: LocalDate,
    val existenciaInicial: Int
) {
    init {
        require(id.isNotBlank()) { Textos.ID_VACIO }
        require(fechaCaducidad.isBefore(LocalDate.now())) {Textos.FECHA_VENCIDA}
        require(existenciaInicial >= 0) { Textos.CANTIDAD_NEGATIVA }
    }
}