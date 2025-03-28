package model.base;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Clase base abstracta para la persistencia de modelos.
 * Proporciona operaciones CRUD básicas para cualquier modelo que extienda de BaseModel.
 * @param <T> tipo de modelo que debe extender de BaseModel
 */
public abstract class BasePersistence<T extends BaseModel> {
	
	/** Contador base para generar IDs */
	private int BASE_ID = 1;
	/** Lista que almacena los modelos */
	private ArrayList<T> models;
	
	/**
	 * Constructor que inicializa la lista de modelos
	 */
	public BasePersistence() {
		models = new ArrayList<>();
	}
	
	/**
	 * Método abstracto para inicialización específica
	 */
	abstract public void init();
	
	/**
	 * Agrega un nuevo modelo a la lista
	 * @param model el modelo a agregar
	 * @return true si se agregó correctamente
	 */
	protected boolean add(T model) {
		model.id = Integer.toString(getIdModel());
		
		return models.add(getCopy(model));
	}
	
	/**
	 * Obtiene todos los modelos almacenados
	 * @return lista con copias de todos los modelos
	 */
	public ArrayList<T> getAll() {
		ArrayList<T> res = new ArrayList<T>();
		
		for (T m : models) {
			res.add(getCopy(m));
		}
		
		return res;
	}
	
	/**
	 * Busca un modelo por su ID
	 * @param id identificador del modelo
	 * @return copia del modelo encontrado o null si no existe
	 */
	protected T getById(String id) {
		T res = null;
		int index = getIndexByID(id);
		
		if (index != -1) {
			res = getCopy(models.get(index));
		}
		
		return res;
	}
	
	/**
	 * Actualiza un modelo existente
	 * @param model modelo con los datos actualizados
	 * @return true si se actualizó correctamente
	 */
	protected boolean updateById(T model) {
		boolean res = false;
		int index = getIndexByID(model.id);
		
		if (index != -1) {
			models.set(index, getCopy(model));
			res = true;
		}
		
		return res;
	}
	
	/**
	 * Elimina un modelo por su ID
	 * @param id identificador del modelo a eliminar
	 * @return true si se eliminó correctamente
	 */
	protected boolean deleteById(String id) {
		boolean res = false;
		int index = getIndexByID(id);
		
		if (index != -1) {
			models.remove(index);
			res = true;
		}
		
		return res;
	}
	
	/**
	 * Busca el índice de un modelo por su ID
	 * @param id identificador del modelo
	 * @return índice del modelo o -1 si no se encuentra
	 */
	protected int getIndexByID(String id) {
		int i = -1;
		for (int pos = 0; pos < models.size(); pos++) {
			if (models.get(pos).id.equals(id)) {
				i = pos;
				break;
			}
		}
		
		return i;
	}
	
	/**
	 * Genera un nuevo ID para un modelo
	 * @return el siguiente ID disponible
	 */
	private int getIdModel() {
		return BASE_ID++;
	}
	
	/**
	 * Crea una copia del modelo
	 * @param model modelo a copiar
	 * @return copia del modelo o null si ocurre un error
	 */
	private T getCopy(T model) {
		try {
			return (T) model.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
