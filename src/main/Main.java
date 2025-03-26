package main;

import java.util.ArrayList;
import java.util.List;

import controller.StoreController;
import model.product.Product;
import model.product.Inventory;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("--Inicio del programa--");
		StoreController storeController = new StoreController();
		storeController.init();
	}
	
}
