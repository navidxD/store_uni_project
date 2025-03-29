package view;

import controller.ViewControllerListener;

// Interfaz base para todas las vistas de la aplicación
public interface BaseView {
	
	// Título común para todas las ventanas de la aplicación
	String title = "MI SUPER TIENDA";
	
	// Método para establecer el listener que comunica la vista con el controlador
	void setViewControllerListener(ViewControllerListener viewControllerListener);
}
