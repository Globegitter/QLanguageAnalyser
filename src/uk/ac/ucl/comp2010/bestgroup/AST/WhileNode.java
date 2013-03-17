package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class WhileNode extends StatementNode{
	public ExprNode condition;
	public LinkedList<StatementNode> statements;
	
	public WhileNode(ExprNode condition, LinkedList<StatementNode> statements) {
		this.condition = condition;
		this.statements = statements;
	}
}
