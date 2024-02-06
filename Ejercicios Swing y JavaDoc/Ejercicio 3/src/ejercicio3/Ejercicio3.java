package src.ejercicio3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa un formulario de inicio de sesión con campo de contraseña.
 * @author Nacho
 * @version 1.0
 */
public class Ejercicio3 extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passwordField;

    /**
     * Constructor de la clase Ejercicio3 que inicializa el formulario de inicio de sesión.
     */
    public Ejercicio3() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        setIconImage(getIconImage()); // Establece el icono de la aplicación

        getContentPane().setBackground(Color.GREEN); // Establece el color de fondo de la aplicación

        // Crear panel principal con BorderLayout y margen
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Panel para los campos de usuario y contraseña con GridLayout y espaciado
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        // Título "Welcome" en la parte superior
        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Source Code Pro Light", Font.BOLD, 24));
        panel.add(welcomeLabel, BorderLayout.NORTH);

        // Campo de texto para el usuario
        JLabel userLabel = new JLabel("User:");
        userField = new JTextField(10);
        inputPanel.add(userLabel);
        inputPanel.add(userField);

        // Campo de contraseña
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(10);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        // Agregar panel de entrada al centro del panel principal
        panel.add(inputPanel, BorderLayout.CENTER);

        // Botón de inicio de sesión en la esquina inferior derecha
        JButton loginButton = new JButton("Log in");
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(loginButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar panel al marco
        add(panel);
        setVisible(true);
    }

    /**
     * Obtiene el icono de la aplicación.
     * @return El icono de la aplicación.
     */
    @Override
    public Image getIconImage() {
        // Carga el icono desde la carpeta "img"
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/monkey.png"));
        return retValue;
    }

    /**
     * Maneja los eventos de clic en el botón de inicio de sesión.
     * Verifica las credenciales ingresadas y muestra un mensaje de éxito o error.
     * Nota: Las credenciales predeterminadas son solo para propósitos de demostración.
     * En una aplicación real, se deben manejar de manera más segura.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passwordField.getPassword());

        // Verificar las credenciales (suponiendo que las credenciales correctas son "admin" y "password")
        if (username.equals("user") && password.equals("password")) {
            JOptionPane.showMessageDialog(this, "¡Inicio de sesión exitoso!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método principal que inicia la aplicación.
     * Crea una instancia de la clase Ejercicio3 y muestra el formulario de inicio de sesión.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ejercicio3::new);
    }
}
