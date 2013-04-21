package uk.ac.ucl.comp2010.bestgroup.AST;

public class EqualsNode extends ExprNode{
	public static int EQUAL = 1;
	public static int NOTEQUAL = 2;
	
	/**
	 * @uml.property  name="op"
	 */
	public int op;
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
	public EqualsNode(int op, ExprNode left, ExprNode right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
}
