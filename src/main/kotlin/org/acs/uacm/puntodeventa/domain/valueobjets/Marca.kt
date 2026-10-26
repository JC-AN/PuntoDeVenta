package org.acs.uacm.puntodeventa.domain.valueobjets

import org.acs.uacm.puntodeventa.domain.constantes.Textos
import org.acs.uacm.puntodeventa.service.Normalizador

/**
 * **Marca**
 * Clase para guardar la Marca de un producto.
 *
 * Esta clase es necesaria para poder guardar los nombres de las
 * Marcas y posteriormente quitarlas o agregarlas.
 *
 * Posibles datos:
 * - LALA
 * - CAPULLO
 * - FRESCA
 *
 * @property id Identificador único de la marca.
 * @property nombre Nombre comercial de la marca.
 * @property activa Indica si la **Marca** se encuentra disponible
 * para registrar nuevos productos.
 *
 * @throws IllegalArgumentException Si el nombre está vacío.
 *
 * @author José Carlos Ascencio Navarro
 * @version 1.0.1
 * @see [Normalizador]
 */
data class Marca (
    var nombre : String,
    val id: Long? = null,
    val activa : Boolean=true
){
    init {
        require(this.nombre.isNotBlank()) { Textos.NOMBRE_VACIO }
        nombre= Normalizador.normalizar(nombre)
    }
}