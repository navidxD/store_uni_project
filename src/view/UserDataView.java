package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UserDataView extends JPanel {
	//-----------------
	// Atributos
	//------------------
	private JTextField 	txtNombre;
	private JTextField 	txtApellido;
	private JTextField 	txtMail;
	private JTextField 	txtId;

	public UserDataView() {
		
		TitledBorder border = BorderFactory.createTitledBorder("Datos del Nuevo Usuario");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		JPanel informacion = new JPanel();
		informacion.setLayout(new GridLayout(4,2,10,5));
		add(informacion, BorderLayout.CENTER);
		
		JLabel labCedula = new JLabel("Cedula");
		txtId = new JTextField();
		
		JLabel labNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		
		JLabel labApellido = new JLabel("Apellido");
		txtApellido = new JTextField();
		
		JLabel labMail = new JLabel("Mail");
		txtMail = new JTextField();

		informacion.add(labCedula);
		informacion.add(txtId);	
		informacion.add(labNombre);
		informacion.add(txtNombre);		
		informacion.add(labApellido);
		informacion.add(txtApellido);	
		informacion.add(labMail);
		informacion.add(txtMail);	
		
	}

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

	public void clean() {
		txtApellido.setText("");
		txtId.setText("");
		txtNombre.setText("");
		txtMail.setText("");
	}
	
	public boolean isInputEmpty(JTextField jTextField) {
		return jTextField.getText() == null || jTextField.getText().isEmpty();
	}

}
