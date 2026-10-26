package org.acs.uacm.puntodeventa.domain.valueobjets
import org.acs.uacm.puntodeventa.domain.constantes.Textos
import org.acs.uacm.puntodeventa.service.Normalizador

/**
 * **CategoriaComercial**
 * Clase para guardar una categoria comercial de un producto
 *
 * Esta clase es necesaria para poder guardar los nombres de las
 * categorias comericiales y posteriormente quitar o agregarlas.
 *
 * Posibles datos:
 * - ABARROTES
 * - BEBIDAS
 * - LACTEOS
 * - FRUTAS Y VERDURAS
 * - PANADERIA Y REPOSTERIA
 *
 * @property id Identificador único de la marca.
 * @property nombre Nombre comercial de la marca.
 * @property activa Indica si la **Categoria Comercial** se encuentra disponible
 * para registrar nuevos productos.
 *
 * @throws IllegalArgumentException Si el nombre esta está vacío.
 *
 * @author José Carlos Ascencio Navarro
 * @version 2.0.2
 * @see Normalizador
 */
data class CategoriaComercial (
    var nombre : String,
    val id: Long? = null,
    val activa : Boolean=true
){
    init {
        require(this.nombre.isNotBlank()) { Textos.NOMBRE_VACIO }
        nombre= Normalizador.normalizar(nombre)
    }
}

