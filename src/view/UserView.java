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
import model.user.User;

public class UserView extends JFrame implements BaseView {
	
	private ViewControllerListener viewControllerListener;
	private UserDataView userDataView;
	
	private JList userList;//declaramos La Lista
	private DefaultListModel model;//declaramos el Modelo
	private JScrollPane scrollList;
	private ArrayList<User> users;
	
	private ListSelectionListener liListSelectionListener = new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent event) {
	        if (!event.getValueIsAdjusting() && !users.isEmpty()){
	            JList source = (JList)event.getSource();
	            int selected = source.getSelectedIndex();
	            if (selected >= 0) {	
	            	User u = users.get(selected);
	            	userDataView.setCedula(u.getIdUser());
	            	userDataView.setName(u.getName());
	            	userDataView.setApellido(u.getLastName());
	            	userDataView.setMail(u.getEmail());
	            }
	        }
	    }
	};
	
	public UserView() {
		setTitle(BaseView.title);
		setSize(600, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		add(centro, BorderLayout.NORTH);
		
		userDataView = new UserDataView();
		centro.add(userDataView, BorderLayout.CENTER);
		
		//instanciamos la lista
		userList = new JList();
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		userList.addListSelectionListener(liListSelectionListener);
		  
		//instanciamos el modelo
		model = new DefaultListModel();
		userList.setModel(model);
		     
		//instanciamos el Scroll que tendra la lista
		scrollList = new JScrollPane();
		scrollList.setBounds(20, 120,220, 80);
		scrollList.setViewportView(userList);
		add(scrollList, BorderLayout.CENTER);
		
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
	}

	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		// TODO Auto-generated method stub
		this.viewControllerListener = viewControllerListener;
	}
	
	public User getUserFromForm() {
		User user = new User();
		
		if (!users.isEmpty() && userList.getSelectedIndex() >= 0) {
			user = users.get(userList.getSelectedIndex());
		}
		
		user.setIdUser(userDataView.getCedula());
		user.setName(userDataView.getNombre());
		user.setLastName(userDataView.getApellido());
		user.setEmail(userDataView.getMail());
		
		return user;
	}
	
	public void updateListUser(ArrayList<User> list) {
		this.users = list;
		model = new DefaultListModel();
		
		for (User p : users) {
			model.addElement(p.toString());;
		}
		
		userList.setModel(model);
	}
	
	public void clean() {
		userDataView.clean();
	}

}
