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

import controller.ViewControllerListener;
import model.product.Product;

public class ProductView extends JFrame implements BaseView {
	
	private ViewControllerListener viewControllerListener;
	private ProductDataView productDataView;
	
	private JList listaNombres;//declaramos La Lista
	private DefaultListModel modelo;//declaramos el Modelo
	private JScrollPane scrollLista;
	
	public ProductView() {
		setTitle(BaseView.title);
		setSize(290, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		add(centro, BorderLayout.NORTH);
		
		productDataView = new ProductDataView();
		centro.add(productDataView, BorderLayout.CENTER);
		
		//instanciamos la lista
		listaNombres = new JList();
		listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		  
		//instanciamos el modelo
		modelo = new DefaultListModel();
		listaNombres.setModel(modelo);
		     
		//instanciamos el Scroll que tendra la lista
		scrollLista = new JScrollPane();
		scrollLista.setBounds(20, 120,220, 80);
		scrollLista.setViewportView(listaNombres);
		add(scrollLista, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("AGREGAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_INVENTORY_ADD);
			}
		});
		JButton btnNewButton_2 = new JButton("REGRESAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_MENU);
			}
		});
		
		
		JPanel buttons = new JPanel();
		add(buttons, BorderLayout.SOUTH);
		
		buttons.add(btnNewButton_1, BorderLayout.EAST);
		buttons.add(btnNewButton_2, BorderLayout.WEST);
	}

	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		// TODO Auto-generated method stub
		this.viewControllerListener = viewControllerListener;
	}
	
	public Product getProductFromForm() {
		Product product = new Product();
		
		product.setPrice(productDataView.getPrecio());
		product.setName(productDataView.getNombre());
		
		return product;
	}
	
	public void updateListProduct(ArrayList<Product> products) {
		modelo = new DefaultListModel();
		for (Product p : products) {
			modelo.addElement(p.toString());;
		}
		listaNombres.setModel(modelo);
	}

}
