package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 *     <li>node id should have 4 characters</li>
 *     <li>node description can have maximal 128 characters</li>
 *     <li>no cycle</li>
 *     <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators {
	
	private List<NodeErrorException> listOfErrors = new ArrayList<NodeErrorException>();
	private List<Node> nodes;
	
	private boolean checkId(String id) throws NodeErrorException {
		if (id.length() == 4)
			return true;
		else {
			throw new NodeErrorException("Bad id " + id);
		}
	}
	
	private boolean checkDescription(String description) throws NodeErrorException {
		if (description.length() < 129)
			return true;
		else {
			throw new NodeErrorException("Bad description " + description);
		}
	}
	
	private boolean checkNoCycle(Node node) throws NodeErrorException {
		Node pre = findNode(node.getPredecessorId());
		if(pre == null) {
			return true;
		} else {
			do {
				if(pre.getPredecessorId().equals(node.getId())) {
					throw new NodeErrorException("There is a cycle with " + node.getId() + " node");
				}
				if(!pre.getPredecessorId().equals("0000"))
					pre = findNode(pre.getPredecessorId());
			} while (pre != null && !pre.getPredecessorId().equals("0000")); 
		}
		return true;
	}
	
	private Node findNode(String id) {
		for(int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).getId().equals(id))
				return nodes.get(i);
		}
		return null;
	}
	
	private boolean checkSubsequents(Node node) throws NodeErrorException {
		try {
			if (!checkNoCycle(node))
				return false;
		} catch (NodeErrorException e) {
			e.printStackTrace();
		}
		
		List<Node> subsequents = new ArrayList<Node>();
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getPredecessorId() == node.getId()) {
				subsequents.add(nodes.get(i));
			}
			if (subsequents.size() > 2)
				throw new NodeErrorException("Still more subsequents!");
			else if (subsequents.size() == 2) {
				if (checkIfPenultimate(subsequents))
					continue;
				throw new NodeErrorException("Still more subsequents!");				
			} else 
				continue;
		}
		return true;
	}
	
	private boolean checkIfPenultimate (List<Node> subsequents) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getPredecessorId() == subsequents.get(0).getId() 
					|| nodes.get(i).getPredecessorId() == subsequents.get(1).getId()) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkNode(Node node) {
		try {
			checkId(node.getId());
		} catch (NodeErrorException e) {
			//e.printStackTrace();
			listOfErrors.add(e);
		}
			try {
				checkDescription(node.getDescription());
			} catch (NodeErrorException e) {
				//e.printStackTrace();
				listOfErrors.add(e);
			}
			try {
				checkNoCycle(node);
			} catch (NodeErrorException e) {
//				e.printStackTrace();
				listOfErrors.add(e);
			}
			try {
				checkSubsequents(node);
			} catch (NodeErrorException e) {
//				e.printStackTrace();
				listOfErrors.add(e);
			}
		return true;
	}
	
    public void validateMethod(List<Node> nodes) {
    	this.nodes = nodes; 
    	
    	for (int i = 0; i < nodes.size(); i++) {
    		boolean validation = checkNode(nodes.get(i));
    		if (validation)
    			continue;
    		else {
    			break;
    		}
    	}
    }
    
    public List<NodeErrorException> getListOfError() {
    	return listOfErrors;
    }

}
