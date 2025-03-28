package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
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

public class CartView extends JFrame implements BaseView {
	
	private ViewControllerListener viewControllerListener;
	
	// user -----------------------------------------------------------------
	
	private JList userList;//declaramos La Lista
	private DefaultListModel modelUser;//declaramos el Modelo
	private JScrollPane scrollListUser;
	private ArrayList<User> users;
	private User selectedUser;
	
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
	
	private JList productListResult;//declaramos La Lista
	private DefaultListModel modelProductsResult;//declaramos el Modelo
	private JScrollPane scrollListProductsResult;
	private Product selectedProductResult;
	
	private ListSelectionListener productListSelectionListener = new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent event) {
	        if (!event.getValueIsAdjusting() && !products.isEmpty()){
	            JList source = (JList)event.getSource();
	            int selected = source.getSelectedIndex();
	            if (selected >= 0) {	
	            	selectedProduct = products.get(selected);
	            	viewControllerListener.onReceiveComand(null, ViewControllerListener.CMD_CART_SELECTED_PRODUCT);
	            }
	        }
	    }
	};
	
	private JList productList;//declaramos La Lista
	private DefaultListModel modelProducts;//declaramos el Modelo
	private JScrollPane scrollListProducts;
	private ArrayList<Product> products;
	private Product selectedProduct;
	
	public CartView() {
		setTitle(BaseView.title);
		setSize(600, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createUserList();
		createProductList();
		createResultSection();
	}
	
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


	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		// TODO Auto-generated method stub
		this.viewControllerListener = viewControllerListener;
	}

	public User getSelectedUser() {
		return selectedUser;
	}
	
	public Product getSelectedProduct() {
		selectedProduct.setQuantity(1);
		
		return selectedProduct;
	}
	
	public void updateListProduct(ArrayList<Product> list) {
		this.products = list;
		modelProducts = new DefaultListModel();
		
		for (Product p : products) {
			modelProducts.addElement(p.toString());
		}
		
		productList.setModel(modelProducts);
	}
	
	public void updateListUser(ArrayList<User> list) {
		this.users = list;
		modelUser = new DefaultListModel();
		
		for (User p : users) {
			modelUser.addElement(p.toString());;
		}
		
		userList.setModel(modelUser);
	}
	
	public void updateResult(Double total, ArrayList<Product> list) {
		modelProductsResult = new DefaultListModel();
		
		for (Product p : list) {
			modelProductsResult.addElement(p.completeInfo());
		}
		
		productListResult.setModel(modelProductsResult);
	}
	
	public void showComplete(String id, User user, Double total) {
		DialogUtil dialogUtil = new DialogUtil();
		dialogUtil.showMessage("Venta completa con ID -> " + id + " USUARIO :: " + user.getIdUser() + " TOTAL = " + total);
		viewControllerListener.onReceiveComand(null, ViewControllerListener.CMD_MENU);
	}

}
