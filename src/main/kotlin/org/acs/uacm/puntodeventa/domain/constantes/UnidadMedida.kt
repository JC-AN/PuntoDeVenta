package org.acs.uacm.puntodeventa.domain.constantes

/**
 * **UnidadMedida**
 * Enumeración que representa las unidades de medida
 * usando el sistema internacional de Unidades, excepto
 * la pieza, pero necesaria en un sitema de inventarios.
 *
 * - **GRAMO**
 * - **KILOGRAMO**
 * - **LITRO**
 * - **MILILITRO**
 * - **PIEZA**
 *
 * @property unidad Muestra la abreviatura de cada unidad de Medida.
 *  - KILOGRAMO se muestra como Kg
 *  - LITRO se muestra como Lt
 *
 * @author José Carlos Ascencio Navarro
 * @version 1.1.0
 */
enum class UnidadMedida(val unidad: String) {
    GRAMO("g"),
    KILOGRAMO("Kg"),
    LITRO("Lt"),
    MILILITRO("ml"),
    PIEZA("pz")
}