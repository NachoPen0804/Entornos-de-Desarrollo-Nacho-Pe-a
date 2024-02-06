package src.ejercicio7;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase que representa una calculadora de edad a partir de la fecha de nacimiento ingresada.
 * Permite al usuario introducir su fecha de nacimiento y calcular su edad en años.
 * Esta clase forma parte de la solución del Ejercicio 7.
 * @author [Tu nombre]
 * @version 1.0
 */
public class Ejercicio7 extends JFrame implements ActionListener {

    private JFormattedTextField fechaNacimientoField; // Campo de texto formateado para la fecha de nacimiento
    private JLabel edadLabel; // Etiqueta para mostrar la edad calculada

    /**
     * Constructor de la clase Ejercicio7 que inicializa la calculadora de edad.
     * Configura la interfaz gráfica y los componentes necesarios.
     */
    public Ejercicio7() {
        setTitle("Calculadora de Edad"); // Establece el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación cuando se cierra la ventana
        setSize(300, 200); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JPanel panel = new JPanel(); // Panel principal
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Establece un diseño de caja vertical para el panel

        JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento:"); // Etiqueta para la fecha de nacimiento
        fechaNacimientoField = new JFormattedTextField(createFormatter("##-##-####")); // Campo de texto formateado para la fecha de nacimiento
        fechaNacimientoField.setColumns(10); // Establece el ancho del campo de texto

        JLabel formatoLabel = new JLabel("(Formato: dd-MM-yyyy)"); // Etiqueta para el formato de la fecha

        JButton calcularButton = new JButton("Calcular Edad"); // Botón para calcular la edad
        calcularButton.addActionListener(this); // ActionListener para el botón de cálculo de edad

        edadLabel = new JLabel("Tu edad es:"); // Etiqueta para mostrar la edad calculada

        panel.add(fechaNacimientoLabel); // Agrega la etiqueta de fecha de nacimiento al panel
        panel.add(fechaNacimientoField); // Agrega el campo de texto de fecha de nacimiento al panel
        panel.add(formatoLabel); // Agrega la etiqueta de formato al panel
        panel.add(calcularButton); // Agrega el botón de cálculo de edad al panel
        panel.add(edadLabel); // Agrega la etiqueta de edad al panel

        add(panel); // Agrega el panel a la ventana

        setVisible(true); // Hace visible la ventana
    }

    /**
     * Método para crear un formateador de máscara para el campo de texto de fecha de nacimiento.
     * @param pattern El patrón de formato para la máscara.
     * @return El formateador de máscara creado.
     */
    private MaskFormatter createFormatter(String pattern) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(pattern); // Crea un nuevo formateador de máscara con el patrón dado
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }

    /**
     * Método para calcular la edad a partir de la fecha de nacimiento.
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     * @return La edad calculada en años.
     */
    private int calcularEdad(Date fechaNacimiento) {
        Calendar today = Calendar.getInstance(); // Obtiene la fecha actual
        Calendar dob = Calendar.getInstance(); // Obtiene una instancia de Calendar para la fecha de nacimiento
        dob.setTime(fechaNacimiento); // Establece la fecha de nacimiento en el Calendar dob
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR); // Calcula la diferencia en años entre el año actual y el año de nacimiento
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--; // Disminuye la edad si aún no ha pasado el cumpleaños este año
        }
        return age; // Devuelve la edad calculada
    }

    /**
     * Maneja los eventos de clic en el botón de calcular edad.
     * Calcula la edad a partir de la fecha de nacimiento ingresada y muestra el resultado.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy"); // Formateador de fecha para analizar la fecha de nacimiento
            Date fechaNacimiento = dateFormatter.parse(fechaNacimientoField.getText()); // Obtiene la fecha de nacimiento del campo de texto y la analiza
            int edad = calcularEdad(fechaNacimiento); // Calcula la edad a partir de la fecha de nacimiento
            edadLabel.setText("Tu edad es: " + edad + " años."); // Muestra la edad calculada en la etiqueta
        } catch (ParseException ex) {
            edadLabel.setText("Fecha de nacimiento inválida."); // Muestra un mensaje de error si la fecha de nacimiento no es válida
        }
    }

    /**
     * Método principal que inicia la aplicación.
     * Crea una instancia de la clase Ejercicio7 y muestra la ventana de la aplicación.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ejercicio7::new); // Crea y muestra la interfaz de usuario en el hilo de despacho de eventos
    }
}
