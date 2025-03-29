package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ViewControllerListener;
import model.product.Product;

// Clase que representa la vista para gestionar productos
public class ProductView extends JFrame implements BaseView {
	
	// Listener para comunicación con el controlador
	private ViewControllerListener viewControllerListener;
	// Panel para mostrar/editar datos del producto
	private ProductDataView productDataView;
	
	// Componentes para la lista de productos
	private JList productList;           // Lista de productos
	private DefaultListModel model;      // Modelo de datos para la lista
	private JScrollPane scrollList;      // Panel de desplazamiento
	private ArrayList<Product> products; // Almacena los productos
	
	// Listener para manejar la selección de productos en la lista
	private ListSelectionListener liListSelectionListener = new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent event) {
	        if (!event.getValueIsAdjusting() && !products.isEmpty()){
	            JList source = (JList)event.getSource();
	            int selected = source.getSelectedIndex();
	            if (selected >= 0) {	
	            	Product p = products.get(selected);
	            	productDataView.setName(p.getName());
	            	productDataView.setPrecio(p.getPrice());
	            }
	        }
	    }
	};
	
	// Constructor de la vista
	public ProductView() {
		setTitle(BaseView.title);
		setSize(600, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Configuración del panel principal
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		add(centro, BorderLayout.NORTH);
		
		// Inicialización del panel de datos del producto
		productDataView = new ProductDataView();
		centro.add(productDataView, BorderLayout.CENTER);
		
		// Configuración de la lista de productos
		productList = new JList();
		productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		productList.addListSelectionListener(liListSelectionListener);
		
		// Configuración del modelo de datos
		model = new DefaultListModel();
		productList.setModel(model);
		     
		// Configuración del panel de desplazamiento
		scrollList = new JScrollPane();
		scrollList.setBounds(20, 120,220, 80);
		scrollList.setViewportView(productList);
		add(scrollList, BorderLayout.CENTER);
		
		// Botones de acción
		JButton btnNewButton_1 = new JButton("AGREGAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_INVENTORY_ADD);
			}
		});
		JButton btnNewButton_2 = new JButton("ACTUALIZAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_INVENTORY_UPDATE);
			}
		});
		JButton btnNewButton_3 = new JButton("BORRAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_INVENTORY_DELETE);
			}
		});
		JButton btnNewButton_0 = new JButton("REGRESAR");
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_MENU);
			}
		});
		
		// Panel para los botones
		JPanel buttons = new JPanel();
		add(buttons, BorderLayout.SOUTH);
		
		buttons.add(btnNewButton_1, BorderLayout.EAST);
		buttons.add(btnNewButton_2, BorderLayout.CENTER);
		buttons.add(btnNewButton_3, BorderLayout.WEST);
		buttons.add(btnNewButton_0, BorderLayout.SOUTH);
	}

	// Método para establecer el listener del controlador
	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		this.viewControllerListener = viewControllerListener;
	}
	
	// Método para obtener los datos del producto del formulario
	public Product getProductFromForm() {
		Product product = new Product();
		
		if (!products.isEmpty() && productList.getSelectedIndex() >= 0) {
			product = products.get(productList.getSelectedIndex());
		}
		
		product.setPrice(productDataView.getPrecio());
		product.setName(productDataView.getNombre());
		
		return product;
	}
	
	// Método para actualizar la lista de productos
	public void updateListProduct(ArrayList<Product> list) {
		this.products = list;
		model = new DefaultListModel();
		
		for (Product p : products) {
			model.addElement(p.toString());
		}
		
		productList.setModel(model);
	}
	
	// Método para limpiar el formulario
	public void clean() {
		productDataView.clean();
	}
}
