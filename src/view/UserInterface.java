package view;

import java.util.Scanner;
import model.product.Product;
import model.user.User;
import model.cart.CartManager;

// Clase que maneja la interfaz de usuario por consola
public class UserInterface {
    // Scanner para leer entrada del usuario
    private Scanner scanner;

    // Constructor de la interfaz
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    // Muestra el menú principal y maneja las opciones del usuario
    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== Sistema de Gestión de Tienda ===");
            System.out.println("1. Crear Producto");
            System.out.println("2. Crear Usuario");
            System.out.println("3. Crear Carrito de Compras");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del scanner

            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    createShoppingCart();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
        }
    }

    // Método para crear un nuevo producto
    private void createProduct() {
        System.out.println("\n=== Crear Producto ===");
        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();
        
        System.out.print("Ingrese la descripción del producto: ");
        String description = scanner.nextLine();
        
        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextDouble();
        
        // Crea y configura el nuevo producto
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        
        System.out.println("¡Producto creado exitosamente!");
    }

    // Método para crear un nuevo usuario
    private void createUser() {
        System.out.println("\n=== Crear Usuario ===");
        System.out.print("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();
        
        System.out.print("Ingrese el correo electrónico: ");
        String email = scanner.nextLine();
        
        System.out.print("Ingrese la contraseña: ");
        String password = scanner.nextLine();
        
        // Crea y configura el nuevo usuario
        User user = new User();
        user.setEmail(email);
        user.setName(username);
        
        System.out.println("¡Usuario creado exitosamente!");
    }

    // Método para crear un nuevo carrito de compras
    private void createShoppingCart() {
        System.out.println("\n=== Crear Carrito de Compras ===");
        System.out.print("Ingrese el correo electrónico del usuario para crear el carrito: ");
        String email = scanner.nextLine();
        
        // Busca el usuario y crea el carrito si existe
        User user = findUserByEmail(email);
        if (user != null) {
            CartManager cartManager = new CartManager();
            cartManager.startSale();
            cartManager.setUser(user);
            System.out.println("¡Carrito de compras creado exitosamente!");
        } else {
            System.out.println("Usuario no encontrado. Por favor, cree un usuario primero.");
        }
    }

    // Método para buscar un usuario por su correo electrónico
    private User findUserByEmail(String email) {
        // TODO: Implementar búsqueda de usuario
        return null;
    }

    // Método principal que inicia la aplicación
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.showMainMenu();
    }
}