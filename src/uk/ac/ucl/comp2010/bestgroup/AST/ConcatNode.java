package uk.ac.ucl.comp2010.bestgroup.AST;

public class ConcatNode extends ExprNode{
	/**
	 * @uml.property  name="left"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode left;
	/**
	 * @uml.property  name="right"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode right;
	public ConcatNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}
}
