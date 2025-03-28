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

public class ProductDataView extends JPanel {
	//-----------------
	// Atributos
	//------------------
	private JTextField 	txtNombre;
	private JFormattedTextField 	txtPrecio;

	public ProductDataView() {
		
		TitledBorder border = BorderFactory.createTitledBorder("Datos del Nuevo Producto");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		JPanel informacion = new JPanel();
		informacion.setLayout(new GridLayout(4,2,10,5));
		add(informacion, BorderLayout.CENTER);
		
		
		JLabel labNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		
	    NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(999);
	    formatter.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatter.setCommitsOnValidEdit(true);
		
		JLabel labPrecio = new JLabel("Precio");
		txtPrecio = new JFormattedTextField(formatter);
				
		informacion.add(labNombre);
		informacion.add(txtNombre);		
		informacion.add(labPrecio);
		informacion.add(txtPrecio);		
		
		txtNombre.setText("");
		txtPrecio.setText("");
	}
	
	public String getNombre() {
		if (isInputEmpty(txtNombre)) {
			return "";
		} else {
			return txtNombre.getText();	
		}
	}
	
	public double getPrecio() {
		if (isInputEmpty(txtPrecio)) {
			return 0;
		} else {
			return Double.parseDouble(txtPrecio.getText());	
		}
	}

	public void setName(String value) {
		txtNombre.setText(value);
	}
	
	public void setPrecio(double value) {
		txtPrecio.setText(Double.toString(value));
	}
	
	public void clean() {
		txtNombre.setText("");
		txtPrecio.setText("");
	}
	
	
	public boolean isInputEmpty(JTextField jTextField) {
		return jTextField.getText() == null || jTextField.getText().isEmpty();
	}
}
