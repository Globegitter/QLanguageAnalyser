package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class RepeatNode extends StatementNode{
	public ExprNode condition;
	public LinkedList<StatementNode> statements;
	
	public RepeatNode(LinkedList<StatementNode> statements, ExprNode condition) {
		this.statements = statements;
		this.condition = condition;
	}
}
