package model.product;

import java.util.ArrayList;

import model.base.BaseModelSortComparator;
import model.base.BasePersistence;

/**
 * Clase que gestiona las operaciones CRUD de productos.
 * Extiende de BasePersistence para manejar la persistencia de datos.
 */
public class ProductManager extends BasePersistence<Product> {
	
	/** Contador base para generar IDs de producto */
	private static int BASE_ID = 1;

	/**
	 * Método de inicialización
	 */
	@Override
	public void init() {
	}
	
	/**
	 * Crea un nuevo producto en el sistema
	 * @param p el producto a crear
	 * @return true si la creación fue exitosa, false en caso contrario
	 */
	public boolean createProduct(Product p) {	
		p.setProductId(getIdProduct());
		return add(p);
	}

	/**
	 * Actualiza la información de un producto existente
	 * @param product el producto con la información actualizada
	 * @return true si la actualización fue exitosa, false si el producto es null
	 */
	public boolean updateProduct(Product product) {
		if (product != null) {
			updateById(product);
			return true;
		}
		return false;
	}
	
	/**
	 * Elimina un producto del sistema
	 * @param product el producto a eliminar
	 * @return true si la eliminación fue exitosa, false si el producto es null
	 */
	public boolean deleteProduct(Product product) {
		if (product != null) {
			deleteById(product.getId());
			return true;
		}
		return false;
	}
	
	
	public ArrayList<Product> getAllProducts() {
		return getAll();
	}
	
	public ArrayList<Product> getProductsSortedByPrice(boolean asc) {
		return getListSortedByCondition(new BaseModelSortComparator<Product>() {
			
			@Override
			public boolean checkConditionToSort(model.product.Product obj1, model.product.Product obj2) {
				if (asc) {
					return obj2.getPrice() < obj1.getPrice();	
				} else {
					return obj2.getPrice() > obj1.getPrice();
				}
			}
			
		});
	}
	
	/**
	 * Genera un nuevo ID para un producto
	 * @return el siguiente ID disponible
	 */
	private int getIdProduct() {
		return BASE_ID++;
	}
}
