package src.ejercicio8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Clase que representa una aplicación simple para visualizar y controlar el valor de un JSlider.
 * El JSlider tiene un rango de valores entre 0 y 100, con un valor predeterminado de 50 y marcas cada 20 unidades.
 * Los valores se actualizan automáticamente e instantáneamente en un cuadro de texto verde.
 * Esta clase forma parte de la solución del ejercicio del JSlider.
 * @author Nacho
 * @version 1.0
 */
public class Ejercicio8 extends JFrame {

    private JSlider slider; // JSlider para seleccionar un valor
    private JTextField valueField; // JTextField para mostrar el valor seleccionado

    /**
     * Constructor de la clase Ejercicio8 que inicializa la ventana de la aplicación.
     * Configura la interfaz gráfica y los componentes necesarios.
     */
    public Ejercicio8() {
        setTitle("JSlider Demo"); // Establece el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación cuando se cierra la ventana
        setSize(300, 150); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JPanel panel = new JPanel(); // Panel principal
        panel.setLayout(new BorderLayout()); // Establece un diseño de borde para el panel

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50); // Crea un nuevo JSlider con valores entre 0 y 100, con un valor predeterminado de 50
        slider.setMajorTickSpacing(20); // Establece las marcas principales cada 20 unidades
        slider.setPaintTicks(true); // Habilita la visualización de las marcas
        slider.setPaintLabels(true); // Habilita la visualización de los valores
        slider.addChangeListener(new ChangeListener() { // Añade un ChangeListener al JSlider
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue(); // Obtiene el valor actual del JSlider
                valueField.setText(String.valueOf(value)); // Actualiza el JTextField con el valor seleccionado
            }
        });

        valueField = new JTextField(String.valueOf(slider.getValue())); // JTextField para mostrar el valor seleccionado
        valueField.setEditable(false); // Desactiva la edición del JTextField
        valueField.setBackground(Color.GREEN); // Establece el color de fondo del JTextField a verde

        panel.add(slider, BorderLayout.NORTH); // Agrega el JSlider en la parte superior del panel
        panel.add(valueField, BorderLayout.CENTER); // Agrega el JTextField en el centro del panel

        add(panel); // Agrega el panel a la ventana

        setVisible(true); // Hace visible la ventana
    }

    /**
     * Método principal que inicia la aplicación.
     * Crea una instancia de la clase Ejercicio8 y muestra la ventana de la aplicación.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ejercicio8::new); // Crea y muestra la interfaz de usuario en el hilo de despacho de eventos
    }
}
