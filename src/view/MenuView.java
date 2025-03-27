package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ViewControllerListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends JFrame implements BaseView {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ViewControllerListener viewControllerListener;

	/**
	 * Create the frame.
	 */
	public MenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("USUARIO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_USER);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("INVENTARIO");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_INVENTORY);
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("VENTA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewControllerListener.onReceiveComand(e, ViewControllerListener.CMD_CART);
			}
		});
		panel.add(btnNewButton);
	}

	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		// TODO Auto-generated method stub
		this.viewControllerListener = viewControllerListener;
	}

	

}
