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
	    doAction(askInfo("����� ��������"), client);
	    run();
	}
	
	private Client getClient() {
		try 
		{
		int id = Integer.parseInt(askInfo("id"));
	    String clientName = askInfo("������ ���");
	    String petName = askInfo("��� �������");
	
	    Optional<Client> o = findClient(id, clientName, petName);
	
	    if(o.isPresent()) {
	        System.out.println("������ ������:");
	        return o.get(); 
	    } else {
	    	Client client = new Client(clientName, id, new Pet(petName));
	        System.out.println("����� ������ ��������:");
	        clients.add(client);
	        return client;
	    }
		} catch(NumberFormatException e) {
	        System.out.println("������! id ������ ���� ����� ������");
	        getClient();
	    }
		return null;
	}
	
	private String askInfo(String info) {
	    System.out.print("������� " + info + ":");
	    return scanner.nextLine();
	}
	
	private Optional<Client> findClient(int id, String clientName, String petName) {
		return clients.stream().filter(i -> i.getId() == id 
	    		&& i.getName().equals(clientName) 
	    		&& i.getPet().getName().equals(petName)).findAny();
	}
	
	private void showClient(Client client) {
	    System.out.println("��� - " + client.getName() +
	    "\nid - " + client.getId() + "\n��� ������� - " +
	    client.getPet().getName());
	}
	
	private void showActions() {
	    System.out.println("������� ��������:\n" +
	    "1 - �������� ��� �������\n" + "2 - �������� ��� �������\n" +
	    "3 - ���� �� ������� ��������\n" +
	    "4 - ���� �� ������� �����(������� � ���������� �������).\n" +
	    "5 - ����� �� ���������\n" +
	    "��������:");
	}
	
	private void doAction(String number, Client client) {
	    switch(number) 
	    {
	    case "1": client.setName(askInfo("����� ��� �������"));
                  System.out.println("��� ������� ��������.");
                  doAction(askInfo("����� ������ ��������:"), client);
	            break;
	    case "2": client.getPet().setName(askInfo("����� ��� �������")); 
                  System.out.println("��� ������� ��������.");
                  doAction(askInfo("����� ������ ��������:"), client);
	            break;
	    case "3": clients.remove(client);
	    		  System.out.println("�� ���� �� ������� ��������.");
	            break;
	    case "4":
	            break;
	    case "5":
		  	    System.out.println("�� ��������.");
		        System.exit(0);
	    default: System.out.println("������! ������������ ����� ��������.");
	        doAction(number, client);       
	    }
	}
}
