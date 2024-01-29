/**
 * La clase EsNegatiuEX es una excepción personalizada que se lanza cuando se intenta operar con un número negativo.
 * @author Nacho
 * @version 1.0
 */
package ejercicio1.clases;

public class EsNegatiuEX extends Exception {
    /**
     * Constructor por defecto que establece un mensaje predefinido.
     */
    public EsNegatiuEX() {
        super("El valor no puede ser negativo");
    }
    /**
     * Constructor que permite establecer un mensaje personalizado.
     * @param msg Mensaje de error personalizado.
     */
    public EsNegatiuEX(String msg) {
        super(msg);
    }
}