package uk.ac.ucl.comp2010.bestgroup.AST;

public class VarTypeNode extends Node {
	public String id;
	public String type;
	
	public VarTypeNode(String id, String type) {
		this.id = id;
		this.type = type;
	}
	
}
