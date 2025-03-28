package main;

import java.util.ArrayList;
import java.util.List;

import controller.StoreController;
import model.product.Product;
import model.product.ProductManager;

/**
 * Clase principal que inicia la aplicación de la tienda.
 */
public class Main {
	
	/**
	 * Punto de entrada principal del programa
	 * @param args argumentos de línea de comandos (no utilizados)
	 */
	public static void main(String[] args) {
		System.out.println("--Inicio del programa--");
		StoreController storeController = new StoreController();
		storeController.init();
	}
}
