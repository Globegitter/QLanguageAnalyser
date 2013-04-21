package uk.ac.ucl.comp2010.bestgroup.AST;

public class NotNode extends ExprNode{
	/**
	 * @uml.property  name="expr"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode expr;
	public NotNode(ExprNode expr) {
		this.expr = expr;
	}
}
