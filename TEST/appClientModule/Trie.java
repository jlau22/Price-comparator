import java.util.Map;


import java.util.TreeMap;





public class Trie {
	private TrieNode root = new TrieNode();
	
	public void insert(String number,Double price) {
		if (search(number)) {
			System.out.println("on list");
			return;	
		}else {
			TrieNode node=this.root;
			char[] num = number.toCharArray();
			for (int i = 0; i < num.length; i++) {
				if (node.children.containsKey(num[i])) {
					node=node.children.get(num[i]);
				}else {
					TrieNode newNode= new TrieNode();
					node.children.put(num[i], newNode);
					node=node.children.get(num[i]);
				}
			}
			node.prefix=number;
			node.price=price;
			node.makeisLast();
		}
		
	}
	
	public TreeMap<String, Double> getprice(String number) {
		if (this.root.children.isEmpty()) {
			return null;
		}
		TrieNode node=this.root;
		TrieNode bestpricenode=new TrieNode();
		char[] num = number.toCharArray();
		
		for (int i = 0; i < num.length-1; i++) {
			if (node.children.containsKey(num[i])) {
				if(node.children.get(num[i]).isLast) {
					bestpricenode=node.children.get(num[i]);
				}
				node=node.children.get(num[i]);
			}
		}
		if (bestpricenode.price == null) {
			return null;
		}
		TreeMap<String, Double> m = new TreeMap<String, Double>();
		m.put(bestpricenode.prefix,bestpricenode.price);
		return m;
	}
	
	private boolean search(String number) {
		if (this.root.children.isEmpty()) {
			return false;
		}
		TrieNode node=this.root;
		char[] num = number.toCharArray();
		for (int i = 0; i < num.length; i++) {
			if (node.children.containsKey(num[i])) {
				node=node.children.get(num[i]);
			}else {
				return false;
			}
		}
		return node.isLastNode();
	}
	
	

	
private class TrieNode{
	String prefix;
	Double price;
	Map<Character, TrieNode> children =  new TreeMap<>();
	Boolean isLast = false;
	
	boolean isLastNode() {
		return this.isLast;
	}
	
    void makeisLast() {														
        this.isLast = true;
    }
}
}
