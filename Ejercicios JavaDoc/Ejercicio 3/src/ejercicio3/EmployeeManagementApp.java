package ejercicio3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Esta aplicación permite gestionar una lista de empleados, permitiendo agregar, eliminar y visualizar información sobre cada uno.
 * Se incluye una interfaz gráfica con opciones para ingresar el nombre del empleado, su cargo y departamento, así como botones para agregar y eliminar empleados.
 * También se proporciona un menú emergente para eliminar empleados de la lista y una ventana de confirmación al cerrar la aplicación.
 *
 * @author Nacho
 * @version 1.0
 */
public class EmployeeManagementApp {

    /**
     * Método principal que inicia la aplicación y crea la interfaz gráfica.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        // Crear una nueva ventana principal
        JFrame mainWindow = new JFrame("Gestión de Empleados");
        mainWindow.setSize(800, 700);
        mainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Desactivar cierre directo

        // Cambiar el color de fondo de la ventana principal
        mainWindow.getContentPane().setBackground(Color.lightGray);

        // Cargar la imagen como un BufferedImage
        BufferedImage iconImage = null;
        try {
            iconImage = ImageIO.read(new File("img\\negrito.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Establecer la imagen como el ícono de la ventana
        if (iconImage != null) {
            mainWindow.setIconImage(iconImage);
        }

        // Crear un panel para añadir componentes
        JPanel panel = new JPanel();
        mainWindow.add(panel);
        panel.setLayout(new BorderLayout());

        // Añadir una lista de empleados
        DefaultListModel<String> employeeListModel = new DefaultListModel<>();
        JList<String> employeeList = new JList<>(employeeListModel);
        JScrollPane scrollPane = new JScrollPane(employeeList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Añadir un panel para el ingreso de datos del empleado
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Añadir un campo de texto para el nombre del empleado
        JTextField nameField = new JTextField();
        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(nameField);

        // Añadir un combobox para seleccionar el cargo del empleado
        String[] positions = {"Gerente", "Supervisor", "Empleado"};
        JComboBox<String> positionComboBox = new JComboBox<>(positions);
        inputPanel.add(new JLabel("Cargo:"));
        inputPanel.add(positionComboBox);

        // Añadir radio buttons para seleccionar el departamento del empleado
        JPanel departmentPanel = new JPanel(new GridLayout(3, 1));
        departmentPanel.setBorder(BorderFactory.createTitledBorder("Departamento"));

        JRadioButton ventasRadioButton = new JRadioButton("Ventas");
        JRadioButton recursosHumanosRadioButton = new JRadioButton("Recursos Humanos");
        JRadioButton produccionRadioButton = new JRadioButton("Producción");

        ButtonGroup departmentGroup = new ButtonGroup();
        departmentGroup.add(ventasRadioButton);
        departmentGroup.add(recursosHumanosRadioButton);
        departmentGroup.add(produccionRadioButton);

        departmentPanel.add(ventasRadioButton);
        departmentPanel.add(recursosHumanosRadioButton);
        departmentPanel.add(produccionRadioButton);

        inputPanel.add(departmentPanel);

        panel.add(inputPanel, BorderLayout.NORTH);

        // Añadir un botón para agregar empleados
        JButton addButton = new JButton("Agregar Empleado");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String position = (String) positionComboBox.getSelectedItem();
                String department = "";

                if (ventasRadioButton.isSelected()) {
                    department = "Ventas";
                } else if (recursosHumanosRadioButton.isSelected()) {
                    department = "Recursos Humanos";
                } else if (produccionRadioButton.isSelected()) {
                    department = "Producción";
                }

                if (!name.isEmpty() && !department.isEmpty()) {
                    String newEmployee = name + " - " + position + " - " + department;
                    employeeListModel.addElement(newEmployee);
                    nameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(mainWindow, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(addButton, BorderLayout.SOUTH);

        // Añadir un menú emergente para eliminar empleados
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteMenuItem = new JMenuItem("Eliminar Empleado");
        deleteMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = employeeList.getSelectedIndex();
                if (selectedIndex != -1) {
                    int confirm = JOptionPane.showConfirmDialog(mainWindow, "¿Estás seguro de que deseas eliminar el empleado?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        employeeListModel.remove(selectedIndex);
                    }
                }
            }
        });
        popupMenu.add(deleteMenuItem);
        employeeList.setComponentPopupMenu(popupMenu);

        // Agregar ventana de confirmación al cerrar la aplicación
        mainWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(mainWindow, "¿Estás seguro de que deseas salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    mainWindow.dispose(); // Cerrar la ventana principal
                }
            }
        });

        // Mostrar la ventana principal
        mainWindow.setVisible(true);
    }
}