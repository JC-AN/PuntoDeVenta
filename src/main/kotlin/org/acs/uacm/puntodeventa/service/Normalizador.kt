package org.acs.uacm.puntodeventa.service

import java.text.Normalizer

/**
 * **Clase Normalizador**.
 * Ofrece el servicio de normalizar un texto a mayusculas.
 *
 * Convierte:
 *  - "Lácteos" -> "LACTEOS"
 *  - "lacteos" -> "LACTEOS"
 *  - "  Lácteos  " -> "LACTEOS"
 *
 * @author José Carlos Ascencio Navarro
 * @version 1.0.1
 */
object Normalizador {
    fun normalizar(texto: String): String =
        Normalizer.normalize(
            /*
             * trim() : Quita los espacios
             */
            texto.trim(),
            /*
             * Forma de normalización Unicode NFD (Normalization Form Decomposed).
             *
             * Descompone los caracteres acentuados o compuestos en un carácter base
             * más sus marcas diacríticas.
             *
             * Ejemplos:
             *     á -> a + ◌́
             *     ü -> u + ◌̈
             *     ñ -> n + ◌̃
             *
             * Se utiliza junto con la expresión regular "\\p{M}+"
             * para eliminar acentos y otros signos diacríticos.
             */
            Normalizer.Form.NFD
        ) /*
         * Expresión regular que coincide con una o más marcas diacríticas Unicode.
         *
         * Se utiliza normalmente después de normalizar una cadena a Form.NFD o Form.NFKD,
         * donde los caracteres acentuados se descomponen en:
         *
         *     letra base + marca diacrítica
         *
         * Ejemplos:
         *     á -> a + ◌́
         *     ü -> u + ◌̈
         *     ñ -> n + ◌̃
         *
         * La expresión "\\p{M}+" encuentra dichas marcas para poder eliminarlas:
         *
         *     "México" -> "Mexico"
         *     "Canción" -> "Cancion"
         *
         * \p{M} = cualquier carácter Unicode de la categoría Mark.
         * +      = una o más ocurrencias consecutivas.
         */
            .replace("\\p{M}+".toRegex(), "")
            .uppercase()
}