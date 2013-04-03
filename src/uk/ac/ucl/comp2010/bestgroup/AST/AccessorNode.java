package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class AccessorNode extends ExprNode {
	public LinkedList<String> path;
	
	public AccessorNode(String id) {
		this.path = new LinkedList<String>();
		this.path.addLast(id);
	}
	
	public AccessorNode(AccessorNode parent, String id) {
		this.path = parent.path;
		this.path.addLast(id);
	}
	
}
