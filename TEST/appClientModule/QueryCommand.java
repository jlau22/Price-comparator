import java.util.Map;


import java.util.TreeMap;




public class QueryCommand implements Command{
	
	private String[] splitter;
	private Map<String, Company> companyMap;
	
	




public QueryCommand(String[] splitter, Map<String, Company> companyMap) {
		this.splitter = splitter;
		this.companyMap = companyMap;
	}





public void execute() {
	String cheapestComName,seccheapestComName,cheapestPrefix,secCheapPrefix;
	cheapestComName = seccheapestComName = cheapestPrefix = secCheapPrefix = "";
	Double cheapestPrice,secCheapPrice;
	cheapestPrice = secCheapPrice = null;
	TreeMap<String,Double> data;
	if(companyMap.isEmpty()) {
		System.out.println("have not any data");					//without any data
		return;
	}else {
		for(var entry : companyMap.entrySet()) {							//each loop to get each company data
			data=entry.getValue().getData().getprice(splitter[1]);			//call Trie.getprice to get that number cheapest price 
			if(data == null ) {												//if the company have that number prefix, serching next company ,
				continue;
			}
			if (cheapestPrice == null) {									//if the cheapest price is null,the company and price will be cheapest
				cheapestComName = entry.getKey();
				cheapestPrefix = data.firstEntry().getKey();
				cheapestPrice = data.firstEntry().getValue();
			}else if (data.firstEntry().getValue() <= cheapestPrice) {		//if the  price is cheaper than cheapest price ,the price will be cheapest price. also,the old cheapest will be second cheapest price 
				seccheapestComName = cheapestComName;
				secCheapPrefix = cheapestPrefix;
				secCheapPrice = cheapestPrice;
				cheapestComName = entry.getKey();
				cheapestPrefix = data.firstEntry().getKey();
				cheapestPrice = data.firstEntry().getValue();
			}
			}
		if (cheapestPrice!=null) {
			if (cheapestPrice.equals(secCheapPrice)) {
				System.out.println(splitter[1]+" "+cheapestComName+" "+cheapestPrefix+" "+cheapestPrice);
				System.out.println(splitter[1]+" "+seccheapestComName+" "+secCheapPrefix+" "+secCheapPrice);
			}else {
				System.out.println(splitter[1]+" "+cheapestComName+" "+cheapestPrefix+" "+cheapestPrice);
			}
		}else {
			System.out.println(splitter[1]+" "+"NA");
		}

	}
}
	
	
}
