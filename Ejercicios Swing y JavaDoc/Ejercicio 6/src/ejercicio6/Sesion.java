package src.ejercicio6;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la ventana de sesión exitosa.
 * Muestra un mensaje indicando que se ha iniciado sesión correctamente.
 * Además, proporciona un botón para salir de la ventana.
 * Esta clase forma parte de la solución del Ejercicio 6.
 * @author Nacho
 * @version 1.0
 */
public class Sesion extends JFrame {

    /**
     * Constructor de la clase Sesion que inicializa la ventana.
     * Configura la apariencia y los componentes necesarios.
     */
    public Sesion() {
        setTitle("YOU'RE LOG IN"); // Establece el título de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra la ventana actual cuando se cierra
        setSize(400, 200); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        JLabel messageLabel = new JLabel("YOU'RE LOG IN"); // Etiqueta de mensaje
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Alinea el texto al centro
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Establece el tipo de fuente y tamaño

        JButton exitButton = new JButton("EXIT"); // Botón para salir de la ventana
        exitButton.addActionListener(e -> dispose()); // ActionListener para cerrar la ventana al hacer clic

        JPanel panel = new JPanel(new BorderLayout()); // Panel principal
        panel.add(messageLabel, BorderLayout.CENTER); // Agrega la etiqueta al centro del panel
        panel.add(exitButton, BorderLayout.SOUTH); // Agrega el botón en la parte inferior del panel

        add(panel); // Agrega el panel a la ventana

        setVisible(true); // Hace visible la ventana
    }
}
