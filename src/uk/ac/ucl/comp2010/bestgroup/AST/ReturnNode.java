package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class ReturnNode extends StatementNode{
	/**
	 * @uml.property  name="expr"
	 * @uml.associationEnd  
	 */
	public ExprNode expr;
		
	public ReturnNode() {
		this.expr = null;
	}
	
	public ReturnNode(ExprNode expr) {
		this.expr = expr;
	}
}
