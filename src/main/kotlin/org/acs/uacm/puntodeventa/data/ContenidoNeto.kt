package org.acs.uacm.puntodeventa.data

import org.acs.uacm.puntodeventa.domain.constantes.Textos
import org.acs.uacm.puntodeventa.domain.constantes.UnidadMedida

/**
 * **ContenidoNeto**
 * Clase que guarda el contenido neto de un producto usando
 * para ello un valor entero y una unidad de medida.
 *
 * Solo representa un objeto que guarda valores por lo que no
 * es necesario que tenga un id porque no tiene identidad, solo
 * forma parte de un Producto.
 *
 * La unidad de medida se obtiene de la clase [UnidadMedida]
 *
 * Posibles datos de entrada:
 * - 1, UnidadMedida.LITRO
 * - 500, UnidadMedida.GRAMO
 * - 5, UnidadMedida.PIEZA
 *
 * @property cantidad Representa la cantidad de contenido
 * @property unidad Es la unidad de medida de tipo [UnidadMedida]
 *
 * @throws IllegalArgumentException Si la cantidad es negativa.
 *
 * @author José Carlos Ascencio Navarro
 * @version 1.0.5
 */
data class ContenidoNeto(
    val cantidad: Int,
    val unidad: UnidadMedida
){
    init {
        require(cantidad > 0) { Textos.CANTIDAD_NEGATIVA }
    }
}