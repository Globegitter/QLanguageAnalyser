package uk.ac.ucl.comp2010.bestgroup.AST;

public abstract class ExprNode extends Node{
	public String type = null;	
	
	public String setType(String type) {
		this.type = type;
		return type;
	}
}
