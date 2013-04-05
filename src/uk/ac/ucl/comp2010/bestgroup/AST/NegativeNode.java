package uk.ac.ucl.comp2010.bestgroup.AST;

public class NegativeNode extends ExprNode{
	public ExprNode expr;
	public NegativeNode(ExprNode expr) {
		this.expr = expr;
	}
}
