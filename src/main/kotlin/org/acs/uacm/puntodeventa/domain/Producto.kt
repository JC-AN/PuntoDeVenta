package org.acs.uacm.puntodeventa.domain
import org.acs.uacm.puntodeventa.domain.constantes.Conservacion
import org.acs.uacm.puntodeventa.domain.constantes.Textos
import org.acs.uacm.puntodeventa.domain.valueobjets.CategoriaComercial
import org.acs.uacm.puntodeventa.domain.valueobjets.ContenidoNeto
import org.acs.uacm.puntodeventa.domain.valueobjets.Marca
import org.acs.uacm.puntodeventa.service.Normalizador
import java.math.BigDecimal

/**
 * **Producto**
 * Representa un producto comercial que puede ser vendido por la tienda.
 *
 * Un producto contiene la información necesaria para identificarlo,
 * clasificarlo, controlar sus existencias y establecer su precio de venta.
 *
 * Todo producto debe contar con:
 * - Un código de barras.
 * - Un nombre.
 * - Una marca.
 * - Un precio válido.
 * - Una categoría comercial.
 * - Un tipo de conservación.
 *
 * Durante su creación se validan las siguientes reglas:
 * - El código de barras no puede estar vacío.
 * - El nombre no puede estar vacío.
 * - El precio no puede ser negativo.
 * - El stock no puede ser negativo.
 *
 * @property barCode Código de barras utilizado para identificar
 * el producto de forma única y es el identificador principal del Producto.
 *
 * @property nombre Denominación o tipo de producto, describe la naturaleza
 * del producto independientemente de su marca, presentación o contenido.
 *
 * Ejemplos:
 * - YOGUR
 * - REFRESCO
 * - LECHE
 *
 * @property marca Marca comercial a la que pertenece el producto.
 *
 * @property precio Precio de venta del producto.
 *
 * @property contenido Contenido neto del producto junto con su
 * unidad de medida.
 *
 * @property stock Cantidad actual de existencias disponibles
 * para su venta.
 *
 * @property categoriaComercial Categoría utilizada para clasificar
 * el producto dentro del catálogo de la tienda.
 *
 * @property tipoConservacion Tipo de conservación requerido para
 * almacenar adecuadamente el producto.
 *
 * @property activo Indica si el producto puede seguir utilizándose
 * en el sistema y estar disponible para su venta.
 *
 * @property descripcion Descripción opcional utilizada para
 * proporcionar información adicional sobre el producto.
 *
 * @throws IllegalArgumentException Si el código de barras está vacío.
 * @throws IllegalArgumentException Si el nombre está vacío.
 * @throws IllegalArgumentException Si el precio es negativo.
 * @throws IllegalArgumentException Si el stock es negativo.
 *
 * @author José Carlos Ascencio Navarro
 * @version 2.3.1
 *
 * @see Marca
 * @see CategoriaComercial
 * @see ContenidoNeto
 * @see Conservacion
*/

data class Producto(
    val barCode: String,
    var nombre: String,
    val marca: Marca,
    val precio: BigDecimal,
    val contenido: ContenidoNeto,
    var stock: Int =0,
    val categoriaComercial: CategoriaComercial,
    val tipoConservacion: Conservacion,
    val activo: Boolean,
    val descripcion: String?,
) {
    init {
        require(barCode.isNotBlank()) { Textos.BARCODE_VACIO }
        require(nombre.isNotBlank()) { Textos.NOMBRE_VACIO }
        nombre = Normalizador.normalizar(nombre)
        require(precio > BigDecimal.ZERO) { Textos.CANTIDAD_CERO }
        require(stock>=0){ Textos.CANTIDAD_NEGATIVA }
    }
}