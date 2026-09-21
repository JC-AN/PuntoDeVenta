package org.acs.uacm.org.acs.uacm.puntodeventa.domain.constantes

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
 * @version 1.0.0
 */

data class CategoriaComercial (
    val categoria : String
)