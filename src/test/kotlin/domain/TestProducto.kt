package domain
import org.acs.uacm.puntodeventa.domain.constantes.Conservacion
import org.acs.uacm.puntodeventa.domain.valueobjets.CategoriaComercial
import org.acs.uacm.puntodeventa.domain.Producto
import org.acs.uacm.puntodeventa.domain.constantes.Textos
import org.acs.uacm.puntodeventa.domain.constantes.UnidadMedida
import org.acs.uacm.puntodeventa.domain.valueobjets.ContenidoNeto
import org.acs.uacm.puntodeventa.domain.valueobjets.Marca
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.math.BigDecimal
import kotlin.test.Test

class TestProducto {
    private lateinit var marca: Marca
    private lateinit var categoria: CategoriaComercial
    private lateinit var contenido: ContenidoNeto

    @BeforeEach
    fun inicializarDatos() {
        marca = Marca(nombre = "Lala")
        categoria = CategoriaComercial(nombre = "Lacteos")
        contenido = ContenidoNeto(cantidad = 1, unidad = UnidadMedida.LITRO)
    }

    @Test
    fun debeCrearProductoValido() {
        val producto = Producto(
            barCode = "7501234567890",
            nombre = "Leche",
            marca = marca,
            precio = BigDecimal("29.90"),
            contenido = contenido,
            stock = 100,
            categoriaComercial = categoria,
            tipoConservacion = Conservacion.REFRIGERADO,
            activo = true,
            descripcion = "Leche entera"
        )

        assertAll(
            { assertEquals("7501234567890", producto.barCode) },
            { assertEquals("LECHE", producto.nombre) },
            { assertEquals(marca, producto.marca) },
            { assertEquals(BigDecimal("29.90"), producto.precio) },
            { assertEquals(contenido, producto.contenido) },
            { assertEquals(100, producto.stock) },
            { assertEquals(categoria, producto.categoriaComercial) },
            { assertEquals(Conservacion.REFRIGERADO, producto.tipoConservacion) },
            { assertTrue(producto.activo) },
            { assertEquals("Leche entera", producto.descripcion) }
        )
    }

    @Test
    fun debeNormalizarNombreAMayusculasYEliminarAcentos() {
        val producto = Producto(
            barCode = "7501234567890",
            nombre = "Lácteos Premium",
            marca = marca,
            precio = BigDecimal("29.90"),
            contenido = contenido,
            stock = 10,
            categoriaComercial = categoria,
            tipoConservacion = Conservacion.REFRIGERADO,
            activo = true,
            descripcion = null
        )

        assertEquals(
            "LACTEOS PREMIUM",
            producto.nombre
        )
    }

    @Test
    fun debeLanzarExcepcionCuandoBarcodeEstaVacio() {
        val excepcion = assertThrows(IllegalArgumentException::class.java) {
            Producto(
                barCode = "",
                nombre = "Leche",
                marca = marca,
                precio = BigDecimal("29.90"),
                contenido = contenido,
                stock = 10,
                categoriaComercial = categoria,
                tipoConservacion = Conservacion.REFRIGERADO,
                activo = true,
                descripcion = null
            )
        }

        assertEquals(
            Textos.BARCODE_VACIO,
            excepcion.message
        )
    }

    @Test
    fun debeLanzarExcepcionCuandoBarcodeContieneSoloEspacios() {
        assertThrows(IllegalArgumentException::class.java) {
            Producto(
                barCode = "    ",
                nombre = "Leche",
                marca = marca,
                precio = BigDecimal("29.90"),
                contenido = contenido,
                stock = 10,
                categoriaComercial = categoria,
                tipoConservacion = Conservacion.REFRIGERADO,
                activo = true,
                descripcion = null
            )
        }
    }

    @Test
    fun debeLanzarExcepcionCuandoNombreEstaVacio() {
        val excepcion = assertThrows(IllegalArgumentException::class.java) {
            Producto(
                barCode = "7501234567890",
                nombre = "",
                marca = marca,
                precio = BigDecimal("29.90"),
                contenido = contenido,
                stock = 10,
                categoriaComercial = categoria,
                tipoConservacion = Conservacion.REFRIGERADO,
                activo = true,
                descripcion = null
            )
        }

        assertEquals(
            Textos.NOMBRE_VACIO,
            excepcion.message
        )
    }

    @Test
    fun debeLanzarExcepcionCuandoNombreContieneSoloEspacios() {
        assertThrows(IllegalArgumentException::class.java) {
            Producto(
                barCode = "7501234567890",
                nombre = "     ",
                marca = marca,
                precio = BigDecimal("29.90"),
                contenido = contenido,
                stock = 10,
                categoriaComercial = categoria,
                tipoConservacion = Conservacion.REFRIGERADO,
                activo = true,
                descripcion = null
            )
        }
    }

    @Test
    fun debeLanzarExcepcionCuandoPrecioEsNegativo() {
        val excepcion = assertThrows(IllegalArgumentException::class.java) {
            Producto(
                barCode = "7501234567890",
                nombre = "Leche",
                marca = marca,
                precio = BigDecimal("-0.01"),
                contenido = contenido,
                stock = 10,
                categoriaComercial = categoria,
                tipoConservacion = Conservacion.REFRIGERADO,
                activo = true,
                descripcion = null
            )
        }

        assertEquals(
            Textos.CANTIDAD_CERO,
            excepcion.message
        )
    }

    @Test
    fun noDebePermitirPrecioCero() {
        val excepcion= assertThrows(IllegalArgumentException::class.java) {
            Producto(
                barCode = "7501234567890",
                nombre = "Leche",
                marca = marca,
                precio = BigDecimal.ZERO,
                contenido = contenido,
                stock = 10,
                categoriaComercial = categoria,
                tipoConservacion = Conservacion.REFRIGERADO,
                activo = true,
                descripcion = null
            )
        }

        assertEquals(
            Textos.CANTIDAD_CERO,
            excepcion.message
        )
    }

    @Test
    fun debeLanzarExcepcionCuandoStockEsNegativo() {
        val excepcion = assertThrows(IllegalArgumentException::class.java) {
            Producto(
                barCode = "7501234567890",
                nombre = "Leche",
                marca = marca,
                precio = BigDecimal("29.90"),
                contenido = contenido,
                stock = -1,
                categoriaComercial = categoria,
                tipoConservacion = Conservacion.REFRIGERADO,
                activo = true,
                descripcion = null
            )
        }

        assertEquals(
            Textos.CANTIDAD_NEGATIVA,
            excepcion.message
        )
    }

    @Test
    fun debePermitirStockCero() {
        assertDoesNotThrow {
            Producto(
                barCode = "7501234567890",
                nombre = "Leche",
                marca = marca,
                precio = BigDecimal("29.90"),
                contenido = contenido,
                stock = 0,
                categoriaComercial = categoria,
                tipoConservacion = Conservacion.REFRIGERADO,
                activo = true,
                descripcion = null
            )
        }
    }

    @Test
    fun debePermitirDescripcionNula() {
        val producto = Producto(
            barCode = "7501234567890",
            nombre = "Leche",
            marca = marca,
            precio = BigDecimal("29.90"),
            contenido = contenido,
            stock = 10,
            categoriaComercial = categoria,
            tipoConservacion = Conservacion.REFRIGERADO,
            activo = true,
            descripcion = null
        )

        assertNull(producto.descripcion)
    }
}