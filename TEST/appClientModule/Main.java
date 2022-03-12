import java.util.ArrayList;

import java.util.Scanner;

import javax.net.ssl.SSLContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.*;


public class Main {
	public static void main(String[] args) {
		final String insertPattern = "(INSERT) ([A-Za-z]+) ([0-9]+) ([0-9]+.[0-9]+)";   //Command syntax
		final String queryPattern = "(QUERY) ([0-9]+)";
		String[] splitter;
		Runner runner=new Runner();
		String input = "";
		Map<String, Company> companyMap= new HashMap<>();
        Scanner inputReader = new Scanner(System.in);
        while(true) {														// infinite loop
            try {
            	input = inputReader.nextLine();								//get the input
            	splitter = input.split("\\s");								//split it with space
            	if (input.matches(insertPattern)) {
            		runner.setCommand(new InsertCommand(splitter,companyMap));
            		runner.start();
				}else if(input.matches(queryPattern)) {
            		runner.setCommand(new QueryCommand(splitter,companyMap));
            		runner.start();
				}
				else {
					throw new java.util.InputMismatchException();			//if there is wrong syntax or not supporting command , throw error
				}
            	
                }catch (java.util.InputMismatchException e) {							
                	System.out.println("Wrong syntax");
        		}
        }
		}
	}


