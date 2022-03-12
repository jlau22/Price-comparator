import java.util.Map;

public class InsertCommand implements Command{
	
	private String[] splitter;
	private Map<String, Company> companyMap;
	


public InsertCommand(String[] splitter, Map<String, Company> companyMap) {
		this.splitter = splitter;
		this.companyMap = companyMap;
	}



public void execute() {
	Company company=companyMap.get(splitter[1]);										//get 1 company 
	Trie x;
	if(company == null ) {																//if there is not company, new company will be created with the data.
		companyMap.put(splitter[1], new Company(splitter[1], new Trie()));
		company=companyMap.get(splitter[1]);											
	}
	company.getData().insert(splitter[2], Double.parseDouble(splitter[3]));				//insert the data to the company
	

}
	
	
}
