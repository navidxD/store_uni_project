package view;

import javax.swing.JOptionPane;

// Clase utilitaria para mostrar diálogos y mensajes en la interfaz gráfica
public class DialogUtil {
	// Método para mostrar un mensaje en una ventana emergente
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
