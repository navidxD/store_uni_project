package view;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import controller.ViewControllerListener;

public class ProductView extends JFrame implements BaseView {
	
	private ViewControllerListener viewControllerListener;
	
	public ProductView() {
		setTitle("gestion de Empresa.. 2024_S1");
		setSize(290, 300);
		setResizable(false);
	}

	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		// TODO Auto-generated method stub
		this.viewControllerListener = viewControllerListener;
	}
	
	

}
