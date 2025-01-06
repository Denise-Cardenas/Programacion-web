
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionDeTipos extends JFrame {
    private JTextField inputField; // Campo de texto para ingresar el número
    private JLabel binarioLabel; // Etiqueta para mostrar el resultado binario
    private JLabel hexadecimalLabel; // Etiqueta para mostrar el resultado hexadecimal
    private JButton convertirButton; // Botón para realizar la conversión

    public ConversionDeTipos() {
        // Configurar la ventana
        setTitle("Conversión de Número");
        setSize(300, 200); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear los componentes
        inputField = new JTextField(10);
        binarioLabel = new JLabel("Binario: ");
        hexadecimalLabel = new JLabel("Hexadecimal: ");
        convertirButton = new JButton("Convertir");

        // Panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1)); // Cuatro filas y una columna
        panel.add(new JLabel("Ingresa un número entero:"));
        panel.add(inputField);
        panel.add(convertirButton);
        panel.add(binarioLabel);
        panel.add(hexadecimalLabel);

        // Agregar el panel a la ventana
        add(panel, BorderLayout.CENTER);

        // Acción cuando se presiona el botón "Convertir"
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Leer el número ingresado
                    int numero = Integer.parseInt(inputField.getText());

                    // Convertir el número a binario y hexadecimal
                    String binario = Integer.toBinaryString(numero);
                    String hexadecimal = Integer.toHexString(numero).toUpperCase();

                    // Actualizar las etiquetas con los resultados
                    binarioLabel.setText("Binario: " + binario);
                    hexadecimalLabel.setText("Hexadecimal: " + hexadecimal);
                } catch (NumberFormatException ex) {
                    // Mostrar error si no es un número válido
                    JOptionPane.showMessageDialog(ConversionDeTipos.this, "Por favor, ingresa un número válido",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Crear la ventana y hacerla visible
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConversionDeTipos().setVisible(true);
            }
        });
    }
}
