package view;

// Importaciones necesarias para la interfaz gráfica y manejo de eventos
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ViewControllerListener;
import model.product.Product;
import model.user.User;

// Clase que representa la vista del carrito de compras
public class CartView extends JFrame implements BaseView {
	
	// Listener para comunicación con el controlador
	private ViewControllerListener viewControllerListener;
	
	// Componentes para la lista de usuarios
	private JList userList; // Lista de usuarios
	private DefaultListModel modelUser; // Modelo de datos para la lista de usuarios
	private JScrollPane scrollListUser; // Panel de desplazamiento para la lista
	private ArrayList<User> users; // Almacena los usuarios
	private User selectedUser; // Usuario seleccionado actualmente
	
	// Componentes para la lista de productos
	private JList productList;
	private DefaultListModel modelProducts;
	private JScrollPane scrollListProducts;
	private ArrayList<Product> products;
	private Product selectedProduct;
	
	// Componentes para la lista de productos seleccionados
	private JList productListResult;
	private DefaultListModel modelProductsResult;
	private JScrollPane scrollListProductsResult;
	private Product selectedProductResult;
	
	// Etiqueta para mostrar el total
	private JLabel jlTotal;
	
	// Listener para la selección de usuarios
	private ListSelectionListener userListSelectionListener = new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent event) {
	        if (!event.getValueIsAdjusting() && !users.isEmpty()){
	            JList source = (JList)event.getSource();
	            int selected = source.getSelectedIndex();
	            if (selected >= 0) {	
	            	selectedUser = users.get(selected);
	            	viewControllerListener.onReceiveComand(null, ViewControllerListener.CMD_CART_SELECTED_USER);
	            }
	        }
	    }
	};

	// Listener para la selección de productos
	private ListSelectionListener productListSelectionListener = new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent event) {
	        if (!event.getValueIsAdjusting() && !products.isEmpty()){
	            JList source = (JList)event.getSource();
	            int selected = source.getSelectedIndex();
	            if (selected >= 0) {	
	            	source.clearSelection();
	            	selectedProduct = products.get(selected);
	            	viewControllerListener.onReceiveComand(null, ViewControllerListener.CMD_CART_SELECTED_PRODUCT);
	            }
	        }
	    }
	};
	
	// Constructor de la vista
	public CartView() {
		setTitle(BaseView.title);
		setSize(600, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createUserList();
		createProductList();
		createResultSection();
	}
	
	// Método para crear la sección de lista de usuarios
	private void createUserList() {
		JPanel panelSelectUser = new JPanel();
		
		TitledBorder borderUser = BorderFactory.createTitledBorder("Seleccione Usuario  de la lista");
		borderUser.setTitleColor(Color.BLUE);
		panelSelectUser.setBorder(borderUser);
		panelSelectUser.setLayout(new BorderLayout());
		panelSelectUser.setSize(600, 300);
		
		//instanciamos la lista 
		userList = new JList();
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		userList.addListSelectionListener(userListSelectionListener);
		  
		//instanciamos el modelo
		modelUser = new DefaultListModel();
		userList.setModel(modelUser);
		     
		//instanciamos el Scroll que tendra la lista
		scrollListUser = new JScrollPane();
		scrollListUser.setBounds(20, 120,220, 80);
		scrollListUser.setViewportView(userList);
		panelSelectUser.add(scrollListUser, BorderLayout.CENTER);
		
		add(panelSelectUser, BorderLayout.NORTH);
	}
	
	// Método para crear la sección de lista de productos
	private void createProductList() {
		JPanel panelSelectProduct = new JPanel();
		
		TitledBorder borderProduct = BorderFactory.createTitledBorder("Seleccione Producto  de la lista");
		borderProduct.setTitleColor(Color.BLUE);
		panelSelectProduct.setBorder(borderProduct);
		panelSelectProduct.setLayout(new BorderLayout());
		panelSelectProduct.setSize(600, 300);
		
		//instanciamos la lista 
		productList = new JList();
		productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		productList.addListSelectionListener(productListSelectionListener);
		  
		//instanciamos el modelo
		modelProducts = new DefaultListModel();
		productList.setModel(modelProducts);
		     
		//instanciamos el Scroll que tendra la lista
		scrollListProducts = new JScrollPane();
		scrollListProducts.setBounds(20, 120,220, 80);
		scrollListProducts.setViewportView(productList);
		panelSelectProduct.add(scrollListProducts, BorderLayout.CENTER);
		
		add(panelSelectProduct, BorderLayout.CENTER);
	}
	
	// Método para crear la sección de resultados y botones
	private void createResultSection() {
		JPanel panelResult = new JPanel();
		
		
		JPanel panelSelectProduct = new JPanel();
		
		TitledBorder borderProduct = BorderFactory.createTitledBorder("Producto Seleccionado");
		borderProduct.setTitleColor(Color.BLUE);
		panelSelectProduct.setBorder(borderProduct);
		panelSelectProduct.setLayout(new BorderLayout());
		panelSelectProduct.setSize(600, 300);
		
		//instanciamos la lista 
		productListResult = new JList();
		  
		//instanciamos el modelo
		modelProductsResult = new DefaultListModel();
		productListResult.setModel(modelProductsResult);
		     
		//instanciamos el Scroll que tendra la lista
		scrollListProductsResult = new JScrollPane();
		scrollListProductsResult.setBounds(20, 120,220, 80);
		scrollListProductsResult.setViewportView(productListResult);
		panelSelectProduct.add(scrollListProductsResult, BorderLayout.CENTER);
		
		jlTotal = new JLabel("TOTAL: 0.0");
		
		panelSelectProduct.add(jlTotal, BorderLayout.SOUTH);
		
		
		TitledBorder borderOptions = BorderFactory.createTitledBorder("OPCIONES");
		borderOptions.setTitleColor(Color.BLUE);
		panelResult.setBorder(borderOptions);
		panelResult.setLayout(new BorderLayout());
		panelResult.setSize(600, 300);
		
		JButton btnNewButton_1 = new JButton("LIMPIAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_CART_CLEAN);
			}
		});
		JButton btnNewButton_2 = new JButton("COMPLETAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_CART_COMPLETE);
			}
		});

		JButton btnNewButton_0 = new JButton("REGRESAR");
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_MENU);
			}
		});
		
		
		JPanel buttons = new JPanel();
		
     	buttons.add(btnNewButton_1, BorderLayout.EAST);
		buttons.add(btnNewButton_2, BorderLayout.CENTER);
		buttons.add(btnNewButton_0, BorderLayout.WEST);
		
		panelResult.add(panelSelectProduct, BorderLayout.CENTER);
		panelResult.add(buttons, BorderLayout.SOUTH);
		
		add(panelResult, BorderLayout.SOUTH);
	}

	// Método para establecer el listener del controlador
	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		this.viewControllerListener = viewControllerListener;
	}

	// Métodos getter para obtener elementos seleccionados
	public User getSelectedUser() {
		return selectedUser;
	}
	
	public Product getSelectedProduct() {		
		return selectedProduct;
	}
	
	// Método para actualizar la lista de productos
	public void updateListProduct(ArrayList<Product> list) {
		this.products = list;
		modelProducts = new DefaultListModel();
		
		for (Product p : products) {
			modelProducts.addElement(p.toString());
		}
		
		productList.setModel(modelProducts);
	}
	
	// Método para actualizar la lista de usuarios
	public void updateListUser(ArrayList<User> list) {
		this.users = list;
		modelUser = new DefaultListModel();
		
		for (User p : users) {
			modelUser.addElement(p.toString());;
		}
		
		userList.setModel(modelUser);
	}
	
	// Método para actualizar la sección de resultados
	public void updateResult(Double total, ArrayList<Product> list) {
		jlTotal.setText("Total :" + total);
		modelProductsResult = new DefaultListModel();
		
		for (Product p : list) {
			modelProductsResult.addElement(p.completeInfo());
		}
		
		productListResult.setModel(modelProductsResult);
	}
	
	// Método para mostrar el mensaje de venta completada
	public void showComplete(String id, User user, Double total) {
		DialogUtil dialogUtil = new DialogUtil();
		dialogUtil.showMessage("Venta completa con ID DE COMPRA -> " + id + " TOTAL = " + total);
		viewControllerListener.onReceiveComand(null, ViewControllerListener.CMD_MENU);
	}
}
