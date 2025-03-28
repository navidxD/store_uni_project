package view;

import javax.swing.JFrame;

import controller.ViewControllerListener;

public class CartView extends JFrame implements BaseView {
	
	private ViewControllerListener viewControllerListener;

	@Override
	public void setViewControllerListener(ViewControllerListener viewControllerListener) {
		// TODO Auto-generated method stub
		this.viewControllerListener = viewControllerListener;
	}
	
	
	
	

}
