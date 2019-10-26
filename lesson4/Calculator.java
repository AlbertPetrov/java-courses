public class Calculator
{
	private float value1;
	private float value2;
	private String operation = "";
	private float result;
	
	public void setValue1(float value1) {
	    this.value1 = value1;
	}
	
	public void setValue2(float value2) {
	    this.value2 = value2;
	}
	
    public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public void doOperation() {
		switch(operation) {
			case "+": add(value1, value2);
				break;
			case "-": sub(value1, value2);
				break;
			case "*": mul(value1, value2);
				break;
			case "/": div(value1, value2);
				break;
			case "^": pow(value1, value2);
				break;
			default: System.out.println("Неверный символ");
		}
	}
	
	public void add(float value1, float value2) {
	    result = value1 + value2;
	}
	
	public void sub(float value1, float value2) {
	    result = value1 - value2;
	}
	
	public void mul(float value1, float value2) {
	    result = value1 * value2;
	}
	
	public void div(float value1, float value2) {
	    result = value1 / value2;
	}
	
	public void pow(float value1, float value2) {
	    float temp = value1;
	    for(int i = 0; i < (int) value2 - 1; i++) { 
	        value1 *= temp; 
	    }
	    result = value1;
	}
	
	public float getResult() {
		return result;
	}
	
	public void cleanResult() {
		result = 0.0f;
	}
	
}