package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class FuncDeclNode extends DeclNode {
	/**
	 * @uml.property  name="id"
	 */
	public String id;
	/**
	 * @uml.property  name="args"
	 */
	public LinkedList<VarTypeNode> args;
	/**
	 * @uml.property  name="type"
	 */
	public String type;
	/**
	 * @uml.property  name="body"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public BlockNode body;
	
	public FuncDeclNode(String id, LinkedList<VarTypeNode> args, String type, BlockNode body) {
		this.id = id;
		this.args = args;
		this.type = type;
		this.body = body;
	}
}
