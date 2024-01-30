package ejercicio2;

/**
 * La clase Password ofrece funcionalidad para la generación y validación de contraseñas.
 * Se proporcionan métodos para generar contraseñas aleatorias y comprobar si una contraseña es suficientemente segura.
 *
 * @author Nacho
 * @version 1.5
 */
public final class Password {
    private final static int LONG_DEF = 8;

    private int longitud;

    private String contrasenya;

    /**
     * Obtiene la longitud actual de la contraseña.
     *
     * @return La longitud de la contraseña.
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Establece la longitud de la contraseña.
     *
     * @param longitud La nueva longitud de la contraseña.
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * Obtiene la contraseña actual.
     *
     * @return La contraseña actual.
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * Genera una contraseña aleatoria basada en la longitud especificada.
     * El algoritmo utiliza funciones aleatorias de Math para generar una combinación de letras
     * minúsculas, mayúsculas y números.
     *
     * @return La contraseña aleatoria generada.
     * @see Math#random()
     * @see Math#floor(double)
     */
    public String generaPassword() {
        String password = "";
        for (int i = 0; i < longitud; i++) {
            int eleccion = ((int) Math.floor(Math.random() * 3 + 1));

            if (eleccion == 1) {
                char minusculas = (char) ((int) Math.floor(Math.random() * (123 - 97) + 97));
                password += minusculas;
            } else {
                if (eleccion == 2) {
                    char mayusculas = (char) ((int) Math.floor(Math.random() * (91 - 65) + 65));
                    password += mayusculas;
                } else {
                    char numeros = (char) ((int) Math.floor(Math.random() * (58 - 48) + 48));
                    password += numeros;
                }
            }
        }
        return password;
    }

    /**
     * Comprueba si la contraseña actual es considerada fuerte.
     * Una contraseña se considera fuerte si contiene al menos 5 números, 1 letra minúscula
     * y 2 letras mayúsculas.
     *
     * @return Verdadero si la contraseña es fuerte; falso en caso contrario.
     * @deprecated Este método está obsoleto desde la versión 1.2, reemplazado por {@link #esFuerte()}.
     */
    @Deprecated
    public boolean esFort() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contrasenya.length(); i++) {
            if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {
                if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
                    cuentamayusculas += 1;
                } else {
                    cuentanumeros += 1;
                }
            }
        }
        if (cuentanumeros >= 5 && cuentaminusculas >= 1 && cuentamayusculas >= 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprueba si la contraseña actual es considerada fuerte.
     * Una contraseña se considera fuerte si contiene al menos 3 números, 1 letra minúscula
     * y 1 letra mayúscula.
     *
     * @return Verdadero si la contraseña es fuerte; falso en caso contrario.
     * @see String#charAt(int)
     */
    public boolean esFuerte() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contrasenya.length(); i++) {
            if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {
                if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
                    cuentamayusculas += 1;
                } else {
                    cuentanumeros += 1;
                }
            }
        }
        if (cuentanumeros >= 3 && cuentaminusculas >= 1 && cuentamayusculas >= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Crea una nueva contraseña con una longitud por defecto.
     */
    public Password() {
        this(LONG_DEF);
    }

    /**
     * Crea una nueva contraseña con la longitud especificada.
     *
     * @param longitud La longitud de la nueva contraseña.
     */
    public Password(int longitud) {
        this.longitud = longitud;
        contrasenya = generaPassword();
    }
}
