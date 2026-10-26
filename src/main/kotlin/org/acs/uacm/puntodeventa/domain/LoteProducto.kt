package org.acs.uacm.puntodeventa.domain

import org.acs.uacm.puntodeventa.domain.constantes.Textos
import java.time.LocalDate

/**
 * **LoteProducto**.
 *
 * Clase que registra lotes de un producto, lo que permite tener
 * productos con diferentes fechas de caducidad y sus existencias.
 *
 * Existe para poder registrar un mismo producto con los mismos atributos
 * o uno ya existente con diferentes:
 * - Fechas de caducidad
 * - Existencia Inicial
 * - Existencia Actual
 *
 * Lo cual permite saber si de un producto algunos ya van a caducar o ya
 * caducaron.
 *
 * @throws IllegalArgumentException Si el id es vacio.
 * @throws IllegalArgumentException Si la fecha es anterior al día actual.
 * @throws IllegalArgumentException Si la existenciaInicial es negativa.
 * @throws IllegalArgumentException Si la existenciaActual es negativa
 *
 * @author José Carlos Ascencio Navarro
 * @version 1.1.0
 * @see [Producto]
 * @see LocalDate
 */

data class LoteProducto (
    val id: String,
    val producto: Producto,
    val fechaCaducidad: LocalDate,
    val existenciaInicial: Int,
    var existenciaActual: Int = 0
) {
    init {
        require(id.isNotBlank()) { Textos.ID_VACIO }
        require(fechaCaducidad.isBefore(LocalDate.now())) {Textos.FECHA_VENCIDA}
        require(existenciaInicial >= 0) { Textos.CANTIDAD_NEGATIVA }
        require(existenciaActual >= 0) { Textos.CANTIDAD_NEGATIVA }
    }
}