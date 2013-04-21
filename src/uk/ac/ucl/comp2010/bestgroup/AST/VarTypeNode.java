package uk.ac.ucl.comp2010.bestgroup.AST;

public class VarTypeNode extends Node {
	/**
	 * @uml.property  name="id"
	 */
	public String id;
	/**
	 * @uml.property  name="type"
	 */
	public String type;
	
	public VarTypeNode(String id, String type) {
		this.id = id;
		this.type = type;
	}
	
}
