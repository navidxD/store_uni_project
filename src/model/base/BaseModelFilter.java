package model.base;

public interface BaseModelFilter<T extends BaseModel> {	
	boolean checkConditionToFilter(T obj1);
}