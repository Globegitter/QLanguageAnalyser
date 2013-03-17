package uk.ac.ucl.comp2010.bestgroup.AST;

public class ArgNode extends Node{
	public String id;
	public String type;
	public ArgNode(String id, String type) {
		this.id = id;
		this.type = type;
	}
}
