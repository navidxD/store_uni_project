package controller;

import java.awt.event.ActionEvent;

public interface ViewControllerListener {

	public int CMD_MENU = 0;
	public int CMD_USER = 1;
	public int CMD_USER_ADD = 11;
	public int CMD_USER_UPDATE = 12;
	public int CMD_USER_DELETE = 13;
	public int CMD_INVENTORY = 2;
	public int CMD_INVENTORY_ADD = 21;
	public int CMD_INVENTORY_UPDATE = 22;
	public int CMD_INVENTORY_DELETE = 23;
	public int CMD_CART = 3;
	public int CMD_CART_SELECTED_USER = 31;
	public int CMD_CART_SELECTED_PRODUCT = 32;
	public int CMD_CART_COMPLETE = 33;
	public int CMD_CART_CLEAN = 34;
	
	
	void onReceiveComand(ActionEvent e, int cmd);
}
