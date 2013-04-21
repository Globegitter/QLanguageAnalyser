package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class FuncCallExprNode extends ExprNode{
	/**
	 * @uml.property  name="id"
	 */
	public String id;
	/**
	 * @uml.property  name="args"
	 */
	public LinkedList<ExprNode> args;
	
	public FuncCallExprNode(String id, LinkedList<ExprNode> args) {
		this.id = id;
		this.args = args;
	}
}
