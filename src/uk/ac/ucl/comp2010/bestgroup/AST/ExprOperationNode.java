package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.Arrays;
import java.util.LinkedList;

public class ExprOperationNode extends ExprNode{
	/**
	 * @uml.property  name="op"
	 */
	public int op;
	/**
	 * @uml.property  name="args"
	 */
	public LinkedList<ExprNode> args;
	
	public ExprOperationNode(int op, ExprNode... args) {
		this.op = op;
		this.args = new LinkedList<ExprNode>(Arrays.asList(args));
	}	
}
