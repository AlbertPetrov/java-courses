import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class VeterinaryClinic {
	
	private final
	    Scanner scanner = new Scanner(System.in);
	private final 
	    List<Client> clients = new ArrayList<>();
	
	public void run() {
		Client client = getClient();
	    showClient(client);
	    showActions();
	    doAction(askInfo("номер действия"), client);
	    run();
	}
	
	private Client getClient() {
		try 
		{
		int id = Integer.parseInt(askInfo("id"));
	    String clientName = askInfo("полное имя");
	    String petName = askInfo("имя питомца");
	
	    Optional<Client> o = findClient(id, clientName, petName);
	
	    if(o.isPresent()) {
	        System.out.println("Клиент найден:");
	        return o.get(); 
	    } else {
	    	Client client = new Client(clientName, id, new Pet(petName));
	        System.out.println("Новый клиент добавлен:");
	        clients.add(client);
	        return client;
	    }
		} catch(NumberFormatException e) {
	        System.out.println("ОШИБКА! id должен быть целым числом");
	        getClient();
	    }
		return null;
	}
	
	private String askInfo(String info) {
	    System.out.print("Введите " + info + ":");
	    return scanner.nextLine();
	}
	
	private Optional<Client> findClient(int id, String clientName, String petName) {
		return clients.stream().filter(i -> i.getId() == id 
	    		&& i.getName().equals(clientName) 
	    		&& i.getPet().getName().equals(petName)).findAny();
	}
	
	private void showClient(Client client) {
	    System.out.println("Имя - " + client.getName() +
	    "\nid - " + client.getId() + "\nИмя питомца - " +
	    client.getPet().getName());
	}
	
	private void showActions() {
	    System.out.println("Введите комманды:\n" +
	    "1 - Изменить имя клиента\n" + "2 - Изменить имя питомца\n" +
	    "3 - Уйти из клиники навсегда\n" +
	    "4 - Уйти из клиники домой(Перейти к следующему клиенту).\n" +
	    "5 - Выйти из программы\n" +
	    "Ожидание:");
	}
	
	private void doAction(String number, Client client) {
	    switch(number) 
	    {
	    case "1": client.setName(askInfo("новое имя клиента"));
                  System.out.println("Имя клиента изменено.");
                  doAction(askInfo("номер нового действия:"), client);
	            break;
	    case "2": client.getPet().setName(askInfo("новое имя питомца")); 
                  System.out.println("Имя питомца изменено.");
                  doAction(askInfo("номер нового действия:"), client);
	            break;
	    case "3": clients.remove(client);
	    		  System.out.println("Вы ушли из клиники навсегда.");
	            break;
	    case "4":
	            break;
	    case "5":
		  	    System.out.println("До свидания.");
		        System.exit(0);
	    default: System.out.println("ОШИБКА! Неправильный номер действия.");
	        doAction(number, client);       
	    }
	}
}
