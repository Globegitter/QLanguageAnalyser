package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class DatatypeDeclNode extends DeclNode {
	public String id;
	public LinkedList<VarTypeNode> fields;
	
	public DatatypeDeclNode(String id, LinkedList<VarTypeNode> fields) {
		this.id = id;
		this.fields = fields;
	}
	
}
