package uk.ac.ucl.comp2010.bestgroup.AST;

public class EqualsNode extends ExprNode{
	public static String EQUAL = "==";
	public static String NOTEQUAL = "!=";
	
	/**
	 * @uml.property  name="op"
	 */
	public String op;
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
	public EqualsNode(String op, ExprNode left, ExprNode right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
}
