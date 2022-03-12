import java.util.Map;

import java.util.TreeMap;




public class Trie {
	
	private TrieNode root = new TrieNode();									
	public Trie() {}
	
    public void insert(String prefix,Double price) {					
        if (search(prefix)) {										//check the prefix is already in the company
        	System.out.println("on list");
            return;
        } else {
            insert(this.root, prefix,price, 0);				//insert new prefix
        }
    }
	
	private void insert(TrieNode node,String prefix,Double price,int x) {
		if(prefix.length() == x) {														//if number of loop is prefix length,the node is last node ,also,insert data in that node
			node.prefix=prefix;
			node.price=price;
			node.makeisLast();
		}else {
			char num = prefix.charAt(x);												//get prefix[x],e.g. 1552 prefix[3]=2															
			if(node.children.containsKey(num)) {										//if number children of this node is exist,get that node children and call the method again
				TrieNode nexTrieNode = node.children.get(num);
				insert(nexTrieNode,prefix,price, x+1);							//x+1
			}else {																		//if the node without any children node,create new children node
				TrieNode newNode= new TrieNode();										
				node.children.put(num, newNode);
				insert(newNode,prefix,price, x+1);
			}
		}
	}
	
	public boolean search(String prefix ) {												
        return search(this.root, prefix, 0);
    }
	
    private boolean search(TrieNode node, String prefix, int d) {				//search the prefix is exist or not in the company
        if (prefix.length() == d) {												 
            return node.isLastNode();											//if the node is last,that means the data already existed.
        }
        char num = prefix.charAt(d);
        if (node.children.containsKey(num)) {									//if that number children of this node is exist,get that node children and call the method again
            return search(node.children.get(num), prefix, d + 1);				
        } else {																//the prefix is not exist in the company
            return false;
        }
    }
    
    public  TreeMap<String, Double> getprice(String number) {					
    	TrieNode x= getpriceNode(this.root,number,0);							//get the number cheapest price in the company
    	if(x.prefix == null) {													//if that company haven't support that number,no any data return
    		return null;
    	}
    	TreeMap<String, Double> m = new TreeMap<String, Double>();				//save the number cheapest price 
    	m.put(x.prefix,x.price);
    	return m;																//return cheapest price
		
	}
    
    
    private TrieNode getpriceNode(TrieNode node, String number, int d) {  
    	if(number.length() - 1==d) {											//return the node before last one number.
    		return node;
    	}
        char num = number.charAt(d);
        if (node.children.containsKey(num)) {
            return getpriceNode(node.children.get(num), number, d + 1);
        } else {
            return node;														//if children of this node is null,that means this node is saved that number prefix price
        }
    }
    
	
	
	
    private class TrieNode {
    	String prefix;													
		Double price;
		Map<Character, TrieNode> children =  new TreeMap<>();
		Boolean isLast = false;													// node is the last or not

		TrieNode() {}														

        boolean isLastNode() {													//getter of the isLast
            return this.isLast;
        }

        void makeisLast() {														//setter of isLast
            this.isLast = true;
        }
        
        

    }
	
	
	

}
