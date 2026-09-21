package org.acs.uacm.org.acs.uacm.puntodeventa.domain
import org.acs.uacm.org.acs.uacm.puntodeventa.domain.constantes.*
import java.math.BigDecimal

/**
 * Clase Producto que representa un producto de una tienda.
 *
 * Utiliza la clase [CategoriaComercial] para representar las categorías
 * de los productos de una tienda.
 *
 * Sus posibles valores son de tipo:
 * - Abarrotes
 * - Bebidas
 * - Lácteos
 * - Carnes y embutidos
 * - Frutas y verduras
 * - Panadería y repostería
 *
 * Utiliza la clase enum [Conservacion] para representar el tipo de conservación
 * que necesita el producto.
 *
 * Sus valores pueden ser:
 * - **SECO**
 * - **REFRIGERADO**:
 * - **CONGELADO**:
 *
 * @author José Carlos Ascencio Navarro
 * @version 1.0.5
 * @see [CategoriaComercial]
 * @see [Conservacion]
 */

data class Producto(
    val barCode: String,
    val nombre: String,
    val descripcion: String,
    val categoriaComercial: CategoriaComercial,
    val precio: BigDecimal,
    val tipoConservacion: Conservacion
) {
    init {
        require(barCode.isNotBlank()) { Textos.BARCODE_VACIO }
        require(nombre.isNotBlank()) { Textos.NOMBRE_VACIO }
        require(precio.signum() >= 0) { Textos.CANTIDAD_NEGATIVA }
    }
}