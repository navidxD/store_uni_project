package model.user;

import java.util.ArrayList;

import model.base.BasePersistence;
import model.product.Product;

/**
 * Clase que gestiona las operaciones CRUD de usuarios.
 * Extiende de BasePersistence para manejar la persistencia de datos.
 */
public class UserManager extends BasePersistence<User> {
	
	/** Contador base para generar IDs de usuario */
	private static int BASE_ID = 1;

	/**
	 * Método de inicialización
	 */
	@Override
	public void init() {
	}
	
	/**
	 * Crea un nuevo usuario en el sistema
	 * @param user el usuario a crear
	 * @return true si la creación fue exitosa, false en caso contrario
	 */
	public boolean createUser(User user) {
		return add(user);
	}
	
	public ArrayList<User> getAllUsers() {
		return getAll();
	}

	/**
	 * Actualiza la información de un usuario existente
	 * @param user el usuario con la información actualizada
	 * @return true si la actualización fue exitosa, false si el usuario es null
	 */
	public boolean updateUser(User user) {
		if (user != null) {
			updateById(user);
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un usuario del sistema
	 * @param user el usuario a eliminar
	 * @return true si la eliminación fue exitosa, false si el usuario es null
	 */
	public boolean deleteUser(User user) {
		if (user != null) {
			deleteById(user.getId());
			return true;
		}
		return false;
	}
	
	/**
	 * Genera un nuevo ID para un usuario
	 * @return el siguiente ID disponible
	 */
	private int getIdUser() {
		return BASE_ID++;
	}
}
