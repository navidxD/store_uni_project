package view;

// Importaciones necesarias para la interfaz gráfica
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.ViewControllerListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Clase principal que representa la vista del menú principal
public class MenuView extends JFrame implements BaseView {

	private static final long serialVersionUID = 1L;
	// Panel principal que contiene todos los elementos
	private JPanel contentPane;
	// Listener para comunicar eventos al controlador
	private ViewControllerListener viewControllerListener;

	/**
	 * Crear el frame principal
	 */
	public MenuView() {
		// Configuración básica de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// Panel que contendrá los botones
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		// Botón para gestionar usuarios
		JButton btnNewButton_1 = new JButton("USUARIO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_USER);
			}
		});
		panel.add(btnNewButton_1);
		
		// Botón para gestionar el inventario
		JButton btnNewButton_2 = new JButton("INVENTARIO");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_INVENTORY);
			}
		});
		panel.add(btnNewButton_2);
		
		// Botón para gestionar ventas
		JButton btnNewButton = new JButton("VENTA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_CART);
			}
		});
		panel.add(btnNewButton);
	}

	// Método para establecer el listener del controlador
	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		this.viewControllerListener = viewControllerListener;
	}
}
