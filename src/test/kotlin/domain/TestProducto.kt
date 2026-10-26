package domain
import org.acs.uacm.puntodeventa.domain.constantes.Conservacion
import org.acs.uacm.puntodeventa.domain.valueobjets.CategoriaComercial
import org.acs.uacm.puntodeventa.domain.Producto
import kotlin.test.Test

class TestProducto {

    @Test
    fun testProducto() {
        Producto(
            barCode = "6546846516",
            nombre = "Yogurt",
            "Sabor Fresa",
            CategoriaComercial("Lacteos"),
            precio = "7.5".toBigDecimal(),
            tipoConservacion = Conservacion.REFRIGERADO
        )
    }
}