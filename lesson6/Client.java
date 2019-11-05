
public class Client {
	
    private String name;
    private int id;
    private Pet pet;
    
    public Client(String name, int id, Pet pet) {
    	this.name = name;
    	this.id = id;
    	this.pet = pet;
    }
    
    public String getName() {
		return name;
	}
    public void setName(String name) {
		this.name = name;
	}
    public int getId() {
		return id;
	}
    public Pet getPet() {
		return pet;
	}
}
