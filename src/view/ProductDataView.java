package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

import model.product.Product;

// Panel para mostrar y editar datos de productos
public class ProductDataView extends JPanel {
	// Atributos para los campos de entrada
	private JTextField 	txtNombre;        // Campo para el nombre del producto
	private JFormattedTextField txtPrecio; // Campo para el precio con formato numérico

	// Constructor del panel
	public ProductDataView() {
		// Configuración del borde con título
		TitledBorder border = BorderFactory.createTitledBorder("Datos del Nuevo Producto");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		// Panel para organizar la información en una cuadrícula
		JPanel informacion = new JPanel();
		informacion.setLayout(new GridLayout(4,2,10,5));
		add(informacion, BorderLayout.CENTER);
		
		// Configuración del campo nombre
		JLabel labNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		
		// Configuración del formato numérico para el precio
	    NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);                    // Valor mínimo permitido
	    formatter.setMaximum(999);                  // Valor máximo permitido
	    formatter.setAllowsInvalid(false);          // No permite valores inválidos
	    formatter.setCommitsOnValidEdit(true);      // Actualiza el valor con cada edición válida
		
		// Configuración del campo precio
		JLabel labPrecio = new JLabel("Precio");
		txtPrecio = new JFormattedTextField(formatter);
				
		// Agregar componentes al panel
		informacion.add(labNombre);
		informacion.add(txtNombre);		
		informacion.add(labPrecio);
		informacion.add(txtPrecio);		
		
		// Inicializar campos vacíos
		txtNombre.setText("");
		txtPrecio.setText("");
	}
	
	// Obtener el nombre del producto
	public String getNombre() {
		if (isInputEmpty(txtNombre)) {
			return "";
		} else {
			return txtNombre.getText();	
		}
	}
	
	// Obtener el precio del producto
	public double getPrecio() {
		if (isInputEmpty(txtPrecio)) {
			return 0;
		} else {
			return Double.parseDouble(txtPrecio.getText());	
		}
	}

	// Establecer el nombre del producto
	public void setName(String value) {
		txtNombre.setText(value);
	}
	
	// Establecer el precio del producto
	public void setPrecio(double value) {
		txtPrecio.setText(Double.toString(value));
	}
	
	// Limpiar todos los campos
	public void clean() {
		txtNombre.setText("");
		txtPrecio.setText("0");
	}
	
	// Verificar si un campo de texto está vacío
	public boolean isInputEmpty(JTextField jTextField) {
		return jTextField.getText() == null || jTextField.getText().isEmpty();
	}
}
