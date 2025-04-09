package model.user;

import model.base.BaseModel;

/**
 * Clase que representa un usuario en el sistema.
 * Extiende de BaseModel para heredar funcionalidades básicas.
 */
public class User extends BaseModel {
	
	/** Identificador único del usuario */
	private String idUser;
	/** Nombre del usuario */
	private String name;
	/** Apellido del usuario */
	private String lastName;
	/** Correo electrónico del usuario */
	private String email;
	
	/**             
	 * Obtiene el ID del usuario
	 * @return el ID del usuario
	 */
	public String getIdUser() {
		return idUser;
	}
	
	/**
	 * Establece el ID del usuario
	 * @param idUser el nuevo ID a establecer
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	/**
	 * Obtiene el nombre del usuario
	 * @return el nombre del usuario
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Establece el nombre del usuario
	 * @param name el nuevo nombre a establecer
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Obtiene el apellido del usuario
	 * @return el apellido del usuario
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Establece el apellido del usuario
	 * @param lastName el nuevo apellido a establecer
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Obtiene el correo electrónico del usuario
	 * @return el correo electrónico del usuario
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Establece el correo electrónico del usuario
	 * @param email el nuevo correo electrónico a establecer
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Devuelve una representación en cadena del objeto User
	 * @return cadena con los datos del usuario
	 */
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
