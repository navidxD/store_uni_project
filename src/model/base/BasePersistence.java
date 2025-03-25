package model.base;

import java.util.ArrayList;
import java.util.function.Predicate;

public abstract class BasePersistence<T extends BaseModel> {
	
	private ArrayList<T> models;
	
	public BasePersistence() {
		models = new ArrayList<>();
	}
	
	abstract public void init();
	
	protected boolean add(T model) {
		int max = 999;
		int min = 001;
		int random = (int)(Math.random() * ((max - min) + 1)) + min;
		model.id = Integer.toString(random);
		
		return models.add(model);
	}
	
	protected ArrayList<T> getAll() {		
		return models;
	}
	
	protected T getById(String id) {
		T res = null;
		
		try {
			for (T model : models) {
				if (model.id.equals(id)) {
					res = (T) model.clone();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	protected boolean updateById(T model) {
		boolean res = false;
		
		
		
		return res;
	}
	
	protected boolean deleteById(String id) {
		boolean res = false;
		
		models.removeIf(new Predicate<T>() {
			@Override
			public boolean test(T t) {
				// TODO Auto-generated method stub
				return t.id.equals(id);
			}
		});
		
		return res;
	}

}
