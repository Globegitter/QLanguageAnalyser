package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class DatatypeDeclNode extends DeclNode {
	/**
	 * @uml.property  name="id"
	 */
	public String id;
	/**
	 * @uml.property  name="fields"
	 */
	public LinkedList<VarTypeNode> fields;
	
	public DatatypeDeclNode(String id, LinkedList<VarTypeNode> fields) {
		this.id = id;
		this.fields = fields;
	}
	
}
