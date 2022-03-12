

public class Company {

	private String name;
	private Trie data;
	
	public Company(String name, Trie data) {
		super();
		this.name = name;
		this.data = data;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Trie getData() {
		return data;
	}
	public void setData(Trie data) {
		this.data = data;
	}
	

	
	
}
