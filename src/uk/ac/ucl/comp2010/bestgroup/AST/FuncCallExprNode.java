package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class FuncCallExprNode extends ExprNode{
	public String id;
	public LinkedList<ExprNode> args;
	
	public FuncCallExprNode(String id, LinkedList<ExprNode> args) {
		this.id = id;
		this.args = args;
	}
}
