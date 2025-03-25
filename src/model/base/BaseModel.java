package model.base;

public class BaseModel implements Cloneable {
	
	protected String id;
	
	public String getId() {
		return id;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
