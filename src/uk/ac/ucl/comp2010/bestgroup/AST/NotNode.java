package uk.ac.ucl.comp2010.bestgroup.AST;

public class NotNode extends ExprNode{
	public ExprNode expr;
	public NotNode(ExprNode expr) {
		this.expr = expr;
	}
}
