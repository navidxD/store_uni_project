package controller;

import java.awt.event.ActionEvent;

public interface ViewControllerListener {

	public int CMD_MENU = 0;
	public int CMD_USER = 1;
	public int CMD_INVENTORY = 2;
	public int CMD_INVENTORY_ADD = 21;
	public int CMD_INVENTORY_UPDATE = 22;
	public int CMD_INVENTORY_DELETE = 23;
	public int CMD_CART = 3;
	
	
	void onReceiveComand(ActionEvent e, int cmd);
}
