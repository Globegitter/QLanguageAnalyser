package uk.ac.ucl.comp2010.bestgroup.AST;

public class NegativeNode extends ExprNode{
	/**
	 * @uml.property  name="expr"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode expr;
	public NegativeNode(ExprNode expr) {
		this.expr = expr;
	}
}
