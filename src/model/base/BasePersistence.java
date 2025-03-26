package model.base;

import java.util.ArrayList;
import java.util.function.Predicate;

public abstract class BasePersistence<T extends BaseModel> {
	
	private int BASE_ID = 1;
	private ArrayList<T> models;
	
	public BasePersistence() {
		models = new ArrayList<>();
	}
	
	abstract public void init();
	
	protected boolean add(T model) {
		model.id = Integer.toString(getIdModel());
		
		return models.add(model);
	}
	
	public ArrayList<T> getAll() {
		ArrayList<T> res = new ArrayList<T>();
		
		for (T m : models) {
			res.add(m);
		}
		
		return res;
	}
	
	protected T getById(String id) {
		T res = null;
		int index = getIndexByID(id);
		
		if (index != -1) {
			res = models.get(index);
		}
		
		return res;
	}
	
	
	protected boolean updateById(T model) {
		boolean res = false;
		int index = getIndexByID(model.id);
		
		if (index != -1) {
			models.set(index, model);
			res = true;
		}
		
		return res;
	}
	
	protected boolean deleteById(String id) {
		boolean res = false;
		int index = getIndexByID(id);
		
		if (index != -1) {
			models.remove(index);
			res = true;
		}
		
		return res;
	}
	
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
	
	private int getIdModel() {
		return BASE_ID++;
	}

}
