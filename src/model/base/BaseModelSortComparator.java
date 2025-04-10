package model.base;

public interface BaseModelSortComparator<T extends BaseModel> {	
	boolean checkConditionToSort(T obj1, T obj2);
}
