/**
 * La clase Principal contiene el método main para probar las funcionalidades de la clase SocUtil.
 * @author Nacho
 * @version 1.0
 */
package ejercicio1;

import ejercicio1.clases.*;

public class Principal {
    /**
     * Método principal que prueba las funcionalidades de la clase SocUtil.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        try {
            System.out.println("12345 es capicua: " + SocUtil.esCapikua(12345));
            System.out.println("1221 es capicua: " + SocUtil.esCapikua(1221));
            System.out.println("1234321 es capicua: " + SocUtil.esCapikua(1234321));
        } catch (EsNegatiuEX ex) {
            // No se maneja la excepción aquí, pero podría hacerse.
        }
    }
}