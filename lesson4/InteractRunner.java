import java.util.Scanner;

public class InteractRunner {
		
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		String exit = "нет";
		String clean = "нет";
		Scanner sc = new Scanner(System.in);		
		while(!exit.equals("да")) {	
			System.out.print("Введите первую цифру:");
			calc.setValue1(Float.valueOf(sc.next()));
			System.out.print("Введите вторую цифру:");
			calc.setValue2(Float.valueOf(sc.next()));
			System.out.print("Введите символ операции.\n"
			    + "Выберите между: +, -, *, /, ^");
			calc.setOperation(sc.next());
			calc.doOperation();
			System.out.println("Результат - " + calc.getResult());
			System.out.println("Очистить результат? Выберите между да или нет:");
			clean = sc.next();
			if(clean.equals("да")) {
				calc.cleanResult();
			}
			System.out.print("Выходим? Выберите между да или нет:");
			exit = sc.next();
		}
		sc.close();
	}
}