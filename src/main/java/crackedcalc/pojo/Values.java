package crackedcalc.pojo;

public class Values {
	private Double value;
	private Double oneMoreValue;
	private String operation;
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setOneMoreValue(Double oneMoreValue) {
		this.oneMoreValue = oneMoreValue;
	}
	
	public Double getOneMoreValue(){
		return oneMoreValue;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getOperation() {
		return this.operation;
	}
}
