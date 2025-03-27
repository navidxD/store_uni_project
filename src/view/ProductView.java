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

public class ProductView extends JFrame implements BaseView {
	
	private ViewControllerListener viewControllerListener;
	private ProductDataView productDataView;
	
	private JList productList;//declaramos La Lista
	private DefaultListModel model;//declaramos el Modelo
	private JScrollPane scrollList;
	private ArrayList<Product> products;
	
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
	
	public ProductView() {
		setTitle(BaseView.title);
		setSize(600, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		add(centro, BorderLayout.NORTH);
		
		productDataView = new ProductDataView();
		centro.add(productDataView, BorderLayout.CENTER);
		
		//instanciamos la lista
		productList = new JList();
		productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		productList.addListSelectionListener(liListSelectionListener);
		  
		//instanciamos el modelo
		model = new DefaultListModel();
		productList.setModel(model);
		     
		//instanciamos el Scroll que tendra la lista
		scrollList = new JScrollPane();
		scrollList.setBounds(20, 120,220, 80);
		scrollList.setViewportView(productList);
		add(scrollList, BorderLayout.CENTER);
		
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
		
		
		JPanel buttons = new JPanel();
		add(buttons, BorderLayout.SOUTH);
		
		buttons.add(btnNewButton_1, BorderLayout.EAST);
		buttons.add(btnNewButton_2, BorderLayout.CENTER);
		buttons.add(btnNewButton_3, BorderLayout.WEST);
		buttons.add(btnNewButton_0, BorderLayout.SOUTH);
	}

	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		// TODO Auto-generated method stub
		this.viewControllerListener = viewControllerListener;
	}
	
	public Product getProductFromForm() {
		Product product = new Product();
		
		if (!products.isEmpty() && productList.getSelectedIndex() >= 0) {
			product = products.get(productList.getSelectedIndex());
		}
		
		product.setPrice(productDataView.getPrecio());
		product.setName(productDataView.getNombre());
		
		return product;
	}
	
	public void updateListProduct(ArrayList<Product> list) {
		this.products = list;
		model = new DefaultListModel();
		
		for (Product p : products) {
			model.addElement(p.toString());;
		}
		
		productList.setModel(model);
	}

}
