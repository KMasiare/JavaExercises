package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

public class NodeGame {

	public static void main(String[] args) {
    	Node n1 = new Node("1111", "blablabla1", "4444");
    	Node n2 = new Node("2222", "blablabla2", "1111");
    	Node n3 = new Node("3333", "blablabla3", "2222");
    	Node n4 = new Node("4444", "blablabla4", "3333");
    	Node n5 = new Node("5555", "blablabla5", "2222");
    	//Node n6 = new Node("6666", "blablabla6", "4444");
    	
    	List<Node> list = new ArrayList<Node>();
    	list.add(n1);
    	list.add(n2);
    	list.add(n3);
    	list.add(n4);
    	list.add(n5);
    	//list.add(n6);
    	
    	NodeValidators nv = new NodeValidators();
    	
    	nv.validateMethod(list);
	}

}
