package uk.ac.ucl.comp2010.bestgroup.AST;

public class EqualsNode extends ExprNode{
	public static int EQUAL = 1;
	public static int NOTEQUAL = 2;
	
	public int op;
	public ExprNode left;
	public ExprNode right;
	public EqualsNode(int op, ExprNode left, ExprNode right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
}
