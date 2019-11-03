public class Calculator
{
	public static void main(String[] args) {
	    Calculator calculator = new Calculator();
	    System.out.println(calculator.pow(
	            Float.valueOf(args[0]), 
	            Float.valueOf(args[1])));
	}
	
	public float add(float left, float right) {
	    return left + right;
	}
	
	public float sub(float left, float right) {
	    return left - right;
	}
	
	public float mul(float left, float right) {
	    return left * right;
	}
	
	public float div(float left, float right) {
	    return left / right;
	}
	
	public float pow(float left, float right) {
	    float temp = left;
	    for(int i = 0; i < (int) right - 1; i++) { 
	        left *= temp; 
	    }
	    return left;
	} 
}
