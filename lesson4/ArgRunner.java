import java.util.Scanner;

public class ArgRunner
{
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Scanner sc = new Scanner(System.in);
		String clean = "нет";
		calc.setLeft(Float.valueOf(args[0]));
		calc.setRight(Float.valueOf(args[2]));
		calc.setOperation(args[1]);
		calc.doOperation();
		System.out.println("Результат - " + calc.getResult());
		System.out.print("Очистить результат? Выберите между да или нет:");
		clean = sc.next();
		if(clean.equals("да")) {
			calc.cleanResult();
		}
		sc.close();
	}
}
