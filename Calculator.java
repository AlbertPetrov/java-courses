public class Calculator
{
	public static void main(String[] args) {
	    Calculator calculator = new Calculator();
	    System.out.println(calculator.pow(
	            Float.valueOf(args[0]), 
	            Float.valueOf(args[1])));
	}
	
	private float add(float value1, float value2) {
	    return value1 + value2;
	}
	
	private float sub(float value1, float value2) {
	    return value1 - value2;
	}
	
	private float mul(float value1, float value2) {
	    return value1 * value2;
	}
	
	private float div(float value1, float value2) {
	    return value1 / value2;
	}
	
	private float pow(float value1, float value2) {
	    float temp = value1;
	    for(int i = 0; i < (int) value2 - 1; i++) { 
	        value1 *= temp; 
	    }
	    return value1;
	} 
}