package model.base;

/**
 * Clase base para todos los modelos del sistema.
 * Implementa Cloneable para permitir la creación de copias de objetos.
 */
public class BaseModel implements Cloneable {
	
	/** Identificador único del modelo */
	protected String id;
	
	/**
	 * Obtiene el ID del modelo
	 * @return el ID del modelo
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Crea una copia del objeto actual
	 * @return una copia del objeto
	 * @throws CloneNotSupportedException si la clonación no está soportada
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
