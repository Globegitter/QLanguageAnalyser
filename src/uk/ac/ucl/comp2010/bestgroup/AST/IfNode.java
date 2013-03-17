package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class IfNode extends StatementNode{
	public ExprNode condition;
	public LinkedList<StatementNode> sTrue;
	public LinkedList<StatementNode> sFalse;
	
	public IfNode(ExprNode condition, LinkedList<StatementNode> sTrue) {
		this(condition, sTrue, new LinkedList<StatementNode>());
	}
	
	public IfNode(ExprNode condition, LinkedList<StatementNode> sTrue, LinkedList<StatementNode> sFalse) {
		this.condition = condition;
		this.sTrue = sTrue;
		this.sFalse = sFalse;
	}
}
