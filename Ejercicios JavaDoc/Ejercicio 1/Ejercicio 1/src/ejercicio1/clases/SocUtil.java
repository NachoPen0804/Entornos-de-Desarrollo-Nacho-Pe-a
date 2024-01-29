/**
 * La clase SocUtil contiene utilidades matemáticas como comprobar si un número es capicúa, primo o calcular su factorial.
 * Además, contiene una excepción personalizada para números negativos.
 * @author Nacho
 * @version 1.0
 */
package ejercicio1.clases;

public class SocUtil {
    /**
     * Comprueba si un número es capicúa.
     * @deprecated Reemplazado por {@link #esCapikua(int)} desde la versión 1.35.
     * @param numero Número a comprobar.
     * @return true si el número es capicúa, false en caso contrario.
     * @throws EsNegatiuEX Si el número es negativo.
     */
    @Deprecated
    public static boolean esCapicua(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        int numAlReves = 0;
        int copia = numero;
        while (numero > 0) {
            numAlReves = numAlReves * 10 + numero % 10;
            numero /= 10;
        }
        return copia == numAlReves;
    }

    /**
     * Comprueba si un número es capicúa.
     * @param numero Número a comprobar.
     * @return true si el número es capicúa, false en caso contrario.
     * @throws EsNegatiuEX Si el número es negativo.
     */
    public static boolean esCapikua(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        String cadNum = numero + "";
        String numAlReves = (new StringBuilder(cadNum)).reverse().toString();
        return cadNum.equals(numAlReves);
    }

    /**
     * Comprueba si un número es primo.
     * @param numero Número a comprobar.
     * @return true si el número es primo, false en caso contrario.
     * @throws EsNegatiuEX Si el número es negativo.
     */
    public static boolean esPrimer(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        int limit = numero / 2 + 1;
        int div = 2;
        while (div < limit) {
            if (numero % div == 0) {
                return false;
            }
            div++;
        }
        return true;
    }

    /**
     * Calcula el factorial de un número.
     * @param numero Número del cual calcular el factorial.
     * @return El factorial del número.
     * @throws EsNegatiuEX Si el número es negativo.
     * @see <a href="http://www.sangakoo.com/es/temas/el-factorial-de-un-numero" target="_blank">Sangaku Maths</a>
     */
    public static long getFactorial(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX("No se puede calcular el factorial de un número negativo");
        }
        long fact = 1L;
        while (numero > 1) {
            fact *= numero;
            numero--;
        }
        return fact;
    }
}