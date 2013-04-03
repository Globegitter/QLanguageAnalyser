package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class ReturnNode extends StatementNode{
	public ExprNode expr;
		
	public ReturnNode() {
		this.expr = null;
	}
	
	public ReturnNode(ExprNode expr) {
		this.expr = expr;
	}
}
