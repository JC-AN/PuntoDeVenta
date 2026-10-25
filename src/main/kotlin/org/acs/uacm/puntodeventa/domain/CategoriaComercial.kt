package org.acs.uacm.puntodeventa.domain
import org.acs.uacm.puntodeventa.domain.constantes.Textos
import org.acs.uacm.puntodeventa.service.Normalizador

/**
 * Clase para guardar una categoria comercial de un producto
 *
 * Esta clase es necesaria para poder guardar los nombres de las
 * categorias comericiales y posteriormente quitar o agregarlas.
 *
 * Posibles datos:
 * - Abarrotes
 * - Bebidas
 * - Lácteos
 * - Carnes y embutidos
 * - Frutas y verduras
 * - Panadería y repostería
 *
 * @author José Carlos Ascencio Navarro
 * @version 2.0.0
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

