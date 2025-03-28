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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ViewControllerListener;
import model.user.User;

public class CartView extends JFrame implements BaseView {
	
	private ViewControllerListener viewControllerListener;
	
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
	
	public CartView() {
		setTitle(BaseView.title);
		setSize(600, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panelSelectUser = new JPanel();
		
		TitledBorder border = BorderFactory.createTitledBorder("Seleccione Usuario  de la lista");
		border.setTitleColor(Color.BLUE);
		panelSelectUser.setBorder(border);
		panelSelectUser.setLayout(new BorderLayout());
		add(panelSelectUser, BorderLayout.NORTH);
		
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
		add(scrollListUser, BorderLayout.CENTER);
		
		/**
		JButton btnNewButton_1 = new JButton("AGREGAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_USER_ADD);
			}
		});
		JButton btnNewButton_2 = new JButton("ACTUALIZAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_USER_UPDATE);
			}
		});
		JButton btnNewButton_3 = new JButton("BORRAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_USER_DELETE);
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
		**/
	}

	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		// TODO Auto-generated method stub
		this.viewControllerListener = viewControllerListener;
	}

	public User getSelectedUser() {
		return selectedUser;
	}
	
	public void updateListUser(ArrayList<User> list) {
		this.users = list;
		modelUser = new DefaultListModel();
		
		for (User p : users) {
			modelUser.addElement(p.toString());;
		}
		
		userList.setModel(modelUser);
	}

}
