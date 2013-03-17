package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class FunctionCallNode extends ExprNode{
	public String function;
	public LinkedList<ExprNode> args;
	public FunctionCallNode(String function, LinkedList<ExprNode> args) {
		this.function = function;
		this.args = args;
	}
}
