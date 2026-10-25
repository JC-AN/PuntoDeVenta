package domain
import org.acs.uacm.puntodeventa.domain.CategoriaComercial
import org.acs.uacm.puntodeventa.domain.constantes.Textos
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * **Clase TestCategoriaComercial**.
 * Clase para realizar los diferentes test a la clase
 * **CategoriaComercial**
 *
 * @see [CategoriaComercial]
 * @author José Carlos Ascencio Navarro
 * @version 1.1.0
 */
class TestCategoriaComercial {
    @Test
    fun testNombreNormalizadoUnaPalabra(){
        val lacteos1 = CategoriaComercial("lácteos")
        val lacteos2 = CategoriaComercial("lacteos")
        val lacteos3 = CategoriaComercial("Lácteos")
        val lacteos4 = CategoriaComercial("lacteos   ")
        val lacteos5 = CategoriaComercial("   lacteos   ")
        val lacteos6 = CategoriaComercial("   lacteos")

        assertEquals(CategoriaComercial(nombre="LACTEOS", id=null, activa=true), lacteos1)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=null, activa=true), lacteos2)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=null, activa=true), lacteos3)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=null, activa=true), lacteos4)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=null, activa=true), lacteos5)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=null, activa=true), lacteos6)
    }

    @Test
    fun testNombreNormalizadoVariasPalabras(){
        val lacteos1 = CategoriaComercial("frutas y verduras")
        val lacteos2 = CategoriaComercial("Frutas y Verduras")
        val lacteos3 = CategoriaComercial("FRUTAS Y VERDURAS")
        val lacteos4 = CategoriaComercial("Frutas Y Verduras   ")
        val lacteos5 = CategoriaComercial("   frutas y verduras   ")
        val lacteos6 = CategoriaComercial("   frutas y verduras")

        assertEquals(CategoriaComercial(nombre="FRUTAS Y VERDURAS", id=null, activa=true), lacteos1)
        assertEquals(CategoriaComercial(nombre="FRUTAS Y VERDURAS", id=null, activa=true), lacteos2)
        assertEquals(CategoriaComercial(nombre="FRUTAS Y VERDURAS", id=null, activa=true), lacteos3)
        assertEquals(CategoriaComercial(nombre="FRUTAS Y VERDURAS", id=null, activa=true), lacteos4)
        assertEquals(CategoriaComercial(nombre="FRUTAS Y VERDURAS", id=null, activa=true), lacteos5)
        assertEquals(CategoriaComercial(nombre="FRUTAS Y VERDURAS", id=null, activa=true), lacteos6)
    }

    @Test
    fun testNombre_ID(){
        val lacteos1 = CategoriaComercial("LACTEOS", 21654189)
        val lacteos2 = CategoriaComercial("lacteos", 34564659874)
        val lacteos3 = CategoriaComercial("lacteos", 324654986513)

        assertEquals(CategoriaComercial(nombre="LACTEOS", id=21654189, activa=true), lacteos1)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=34564659874, activa=true), lacteos2)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=324654986513, activa=true), lacteos3)
    }

    @Test
    fun testNombreVacio(){
        val excepcion1 = assertThrows<IllegalArgumentException> { CategoriaComercial("", 21654189) }
        val excepcion2 = assertThrows<IllegalArgumentException> {  CategoriaComercial("",)}
        val excepcion3 = assertThrows<IllegalArgumentException> {  CategoriaComercial("", 324654986513, activa=false)}
        val excepcion4 = assertThrows<IllegalArgumentException> {  CategoriaComercial("      ", 324654986513, activa=false)}

        assertEquals(Textos.NOMBRE_VACIO, excepcion1.message)
        assertEquals(Textos.NOMBRE_VACIO, excepcion2.message)
        assertEquals(Textos.NOMBRE_VACIO, excepcion3.message)
        assertEquals(Textos.NOMBRE_VACIO, excepcion4.message)
    }

    @Test
    fun testInformacionCompleta(){
        val lacteos1 = CategoriaComercial("LACTEOS", 21654189,false)
        val lacteos2 = CategoriaComercial("lacteos", 34564659874, true)
        val lacteos3 = CategoriaComercial("lacteos", 324654986513,false)

        assertEquals(CategoriaComercial(nombre="LACTEOS", id=21654189, activa=false), lacteos1)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=34564659874, activa=true), lacteos2)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=324654986513, activa=false), lacteos3)
    }

    @Test
    fun testInfoDesordenada(){
        val lacteos1 = CategoriaComercial(id=21654189,nombre="LACTEOS",activa=false)
        val lacteos2 = CategoriaComercial(activa = false, nombre = "lacteos", id=34564659874)
        val lacteos3 = CategoriaComercial(id = 324654986513, activa = true, nombre = "lacteos")
        val lacteos4=CategoriaComercial(id = 98765134, nombre = "lacteos")

        assertEquals(CategoriaComercial(nombre="LACTEOS", id=21654189, activa=false), lacteos1)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=34564659874, activa=false), lacteos2)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=324654986513, activa=true), lacteos3)
        assertEquals(CategoriaComercial(nombre="LACTEOS", id=98765134, activa=true), lacteos4)
    }
}