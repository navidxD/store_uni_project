package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.product.Product;

public class ProductDataView extends JPanel {
	//-----------------
	// Atributos
	//------------------
	private JTextField 	txtNombre;
	private JTextField 	txtPrecio;

	public ProductDataView() {
		
		TitledBorder border = BorderFactory.createTitledBorder("Datos del Nuevo Producto");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		JPanel informacion = new JPanel();
		informacion.setLayout(new GridLayout(4,2,10,5));
		add(informacion, BorderLayout.CENTER);
		
		
		JLabel labNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		
		JLabel labPrecio = new JLabel("Precio");
		txtPrecio = new JTextField();
				
		informacion.add(labNombre);
		informacion.add(txtNombre);		
		informacion.add(labPrecio);
		informacion.add(txtPrecio);		
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
	
	public boolean isInputEmpty(JTextField jTextField) {
		return jTextField.getText() == null || jTextField.getText().isEmpty();
	}
}
