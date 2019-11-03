public class Calculator
{
	private float left;
	private float right;
	private String operation = "";
	private float result;
	
	public void setLeft(float left) {
	    this.left = left;
	}
	
	public void setRight(float right) {
	    this.right = right;
	}
	
    public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public void doOperation() {
		switch(operation) {
			case "+": add(left, right);
				break;
			case "-": sub(left, right);
				break;
			case "*": mul(left, right);
				break;
			case "/": div(left, right);
				break;
			case "^": pow(left, right);
				break;
			default: System.out.println("Неверный символ");
		}
	}
	
	public void add(float left, float right) {
	    result = left + right;
	}
	
	public void sub(float left, float right) {
	    result = left - right;
	}
	
	public void mul(float left, float right) {
	    result = left * right;
	}
	
	public void div(float left, float right) {
	    result = left / right;
	}
	
	public void pow(float left, float right) {
	    float temp = left;
	    for(int i = 0; i < (int) right - 1; i++) { 
	        left *= temp; 
	    }
	    result = left;
	}
	
	public float getResult() {
		return result;
	}
	
	public void cleanResult() {
		result = 0.0f;
	}
	
}
