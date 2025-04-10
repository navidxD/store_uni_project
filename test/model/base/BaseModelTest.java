package model.base;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.base.BaseModel;
import model.base.BasePersistence;
import model.product.Product;
import model.product.ProductManager;

class BaseModelTest {
	
	ArrayList<BaseModel> list = new ArrayList<BaseModel>();
	
	BasePersistence<BaseModel> persistence = new BasePersistence<BaseModel>() {

		@Override
		public void init() {
			// TODO Auto-generated method stub
			
		}
	};
	

	@Test
	void testCreate() {
		persistence.init();
		
		System.out.println("-TEST CREATE-");
		
		for (int i = 0; i < 10; i++) {
			persistence.add(new BaseModel());
		}
		
	}
	
	@Test
	void testPrintAll() {
		testCreate();
		System.out.println("-TEST PRINT ALL-");
		
		list = persistence.getAll();
		
		for (BaseModel p : list) {
			System.out.println(p.getId() + "-");
		}
		
	}
	
	@Test
	void testSort() {
		testCreate();
		System.out.println("-TEST SORT LIST-");
		
		list = persistence.getListSortedByCondition(new BaseModelSortComparator<BaseModel>() {
			
			@Override
			public boolean checkConditionToSort(BaseModel obj1, BaseModel obj2) {
				// TODO Auto-generated method stub
				return (obj2.id.compareTo(obj1.id)) < 0;
			}
		});
		
		for (BaseModel p : list) {
			System.out.print(p.getId() + "-");
		}
		
	}
	
	@Test
	void testFilter() {	
		testCreate();
		System.out.println("-TEST FILTER LIST-");
		
		list = persistence.getListFilterByCondition(new BaseModelFilter<BaseModel>() {
			
			@Override
			public boolean checkConditionToFilter(BaseModel obj1) {
				// TODO Auto-generated method stub
				return obj1.id.contains("4") || obj1.id.contains("3");
			}
		});
		
		for (BaseModel p : list) {
			System.out.print(p.getId() + "-");
		}
		
	}

}
