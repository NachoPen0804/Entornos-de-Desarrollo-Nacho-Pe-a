package src.ejercicio4;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa un formulario de inicio de sesión con campo de contraseña.
 * Permite al usuario iniciar sesión con un nombre de usuario y una contraseña, y
 * cambiar el color de fondo del formulario.
 * También proporciona comentarios detallados para entender el funcionamiento del código.
 * @author Nacho
 * @version 1.0
 */
public class Ejercicio4 extends JFrame implements ActionListener {
    private JTextField userField; // Campo de texto para ingresar el nombre de usuario
    private JPasswordField passwordField; // Campo de contraseña para ingresar la contraseña
    private JPanel panel; // Panel principal que contiene todos los componentes

    /**
     * Constructor de la clase Ejercicio4 que inicializa el formulario de inicio de sesión.
     * Configura la interfaz gráfica y los componentes necesarios.
     */
    public Ejercicio4() {
        setTitle("Login"); // Establece el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación cuando se cierra la ventana
        setSize(300, 200); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        setIconImage(getIconImage()); // Establece el icono de la ventana

        panel = new JPanel(new BorderLayout()); // Crea un panel con un diseño de borde
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Establece un borde vacío alrededor del panel

        JLabel welcomeLabel = new JLabel("Welcome"); // Etiqueta de bienvenida
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Alinea el texto al centro
        welcomeLabel.setFont(new Font("Source Code Pro Light", Font.BOLD, 24)); // Establece el tipo de fuente y tamaño
        panel.add(welcomeLabel, BorderLayout.NORTH); // Agrega la etiqueta al panel en la parte superior

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5)); // Panel para los campos de entrada
        // Crea etiquetas para el nombre de usuario y la contraseña
        JLabel userLabel = new JLabel("User:");
        JLabel passwordLabel = new JLabel("Password:");

        userField = new JTextField(10); // Campo de texto para ingresar el nombre de usuario
        passwordField = new JPasswordField(10); // Campo de contraseña para ingresar la contraseña

        // Agrega las etiquetas y los campos de texto al panel de entrada
        inputPanel.add(userLabel);
        inputPanel.add(userField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        panel.add(inputPanel, BorderLayout.CENTER); // Agrega el panel de entrada al centro del panel principal

        JPanel buttonPanel = new JPanel(new BorderLayout()); // Panel para los botones

        JPanel loginButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Panel para el botón de inicio de sesión

        JPanel toggleButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Panel para el botón de alternancia de color
        JToggleButton colorToggleButton = new JToggleButton("Cambiar Color"); // Botón para cambiar el color de fondo
        // ActionListener para cambiar el color cuando se hace clic en el botón
        colorToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (colorToggleButton.isSelected()) {
                    // Cambia el color de fondo a azul cuando el botón está seleccionado
                    panel.setBackground(Color.BLUE);
                    inputPanel.setBackground(Color.BLUE);
                    buttonPanel.setBackground(Color.BLUE);
                    toggleButtonPanel.setBackground(Color.BLUE);
                    loginButtonPanel.setBackground(Color.BLUE);
                } else {
                    // Cambia el color de fondo a verde cuando el botón no está seleccionado
                    panel.setBackground(Color.GREEN);
                    inputPanel.setBackground(Color.GREEN);
                    buttonPanel.setBackground(Color.GREEN);
                    toggleButtonPanel.setBackground(Color.GREEN);
                    loginButtonPanel.setBackground(Color.GREEN);
                }
            }
        });
        toggleButtonPanel.add(colorToggleButton); // Agrega el botón de alternancia de color al panel

        buttonPanel.add(toggleButtonPanel, BorderLayout.WEST); // Agrega el panel de alternancia de color a la izquierda del panel de botones

        JButton loginButton = new JButton("Log in"); // Botón de inicio de sesión
        loginButton.addActionListener(this); // ActionListener para el botón de inicio de sesión
        loginButton.setFocusable(false); // Desactiva el enfoque del botón
        loginButtonPanel.add(loginButton); // Agrega el botón de inicio de sesión al panel de inicio de sesión

        buttonPanel.add(loginButtonPanel, BorderLayout.EAST); // Agrega el panel de inicio de sesión a la derecha del panel de botones

        panel.add(buttonPanel, BorderLayout.SOUTH); // Agrega el panel de botones al final del panel principal

        add(panel); // Agrega el panel principal al marco
        setVisible(true); // Hace visible el marco y sus componentes
    }

    /**
     * Obtiene el icono de la aplicación.
     * @return El icono de la aplicación.
     */
    @Override
    public Image getIconImage() {
        // Carga el icono desde la carpeta "img"
        return Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/monkey.png"));
    }

    /**
     * Maneja los eventos de clic en el botón de inicio de sesión.
     * Verifica las credenciales ingresadas y muestra un mensaje de éxito o error.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText(); // Obtiene el nombre de usuario ingresado
        String password = new String(passwordField.getPassword()); // Obtiene la contraseña ingresada

        // Verifica las credenciales (suponiendo que las credenciales correctas son "user" y "password")
        if (username.equals("user") && password.equals("password")) {
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método principal que inicia la aplicación.
     * Crea una instancia de la clase Ejercicio4 y muestra el formulario de inicio de sesión.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ejercicio4::new); // Crea y muestra la interfaz de usuario en el hilo de despacho de eventos
    }
}
