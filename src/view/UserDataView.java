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

// Panel para mostrar y editar datos de usuarios
public class UserDataView extends JPanel {
	// Atributos para los campos de entrada
	private JTextField 	txtNombre;    // Campo para el nombre
	private JTextField 	txtApellido;  // Campo para el apellido
	private JTextField 	txtMail;      // Campo para el correo electrónico
	private JFormattedTextField txtId; // Campo para la cédula con formato numérico

	// Constructor del panel
	public UserDataView() {
		// Configuración del borde con título
		TitledBorder border = BorderFactory.createTitledBorder("Datos del Nuevo Usuario");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		// Panel para organizar la información en una cuadrícula
		JPanel informacion = new JPanel();
		informacion.setLayout(new GridLayout(4,2,10,5));
		add(informacion, BorderLayout.CENTER);
		
		// Configuración del formato numérico para la cédula
	    NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);                    // Valor mínimo permitido
	    formatter.setMaximum(999);                  // Valor máximo permitido
	    formatter.setAllowsInvalid(false);          // No permite valores inválidos
	    formatter.setCommitsOnValidEdit(true);      // Actualiza el valor con cada edición válida

		// Creación y configuración de etiquetas y campos de texto
		JLabel labCedula = new JLabel("Cedula");
		txtId = new JFormattedTextField(formatter);
		
		JLabel labNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		
		JLabel labApellido = new JLabel("Apellido");
		txtApellido = new JTextField();
		
		JLabel labMail = new JLabel("Mail");
		txtMail = new JTextField();

		// Agregar componentes al panel de información
		informacion.add(labCedula);
		informacion.add(txtId);	
		informacion.add(labNombre);
		informacion.add(txtNombre);		
		informacion.add(labApellido);
		informacion.add(txtApellido);	
		informacion.add(labMail);
		informacion.add(txtMail);	
	}

	// Métodos para obtener los valores de los campos
	public String getCedula() {
		if (isInputEmpty(txtId)) {
			return "";
		} else {
			return txtId.getText();	
		}
	}
	
	public String getNombre() {
		if (isInputEmpty(txtNombre)) {
			return "";
		} else {
			return txtNombre.getText();	
		}
	}
	
	public String getApellido() {
		if (isInputEmpty(txtApellido)) {
			return "";
		} else {
			return txtApellido.getText();	
		}
	}
	
	public String getMail() {
		if (isInputEmpty(txtMail)) {
			return "";
		} else {
			return txtMail.getText();	
		}
	}
	
	// Métodos para establecer los valores de los campos
	public void setCedula(String value) {
		txtId.setText(value);
	}
	
	public void setNombre(String value) {
		txtNombre.setText(value);
	}
	
	public void setApellido(String value) {
		txtApellido.setText(value);
	}
	
	public void setMail(String value) {
		txtMail.setText(value);
	}

	// Método para limpiar todos los campos
	public void clean() {
		txtApellido.setText("");
		txtId.setText("");
		txtNombre.setText("");
		txtMail.setText("");
	}
	
	// Método para verificar si un campo de texto está vacío
	public boolean isInputEmpty(JTextField jTextField) {
		return jTextField.getText() == null || jTextField.getText().isEmpty();
	}
}
