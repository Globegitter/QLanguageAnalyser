package uk.ac.ucl.comp2010.bestgroup.AST;

public class InNode extends ExprNode{
	public ExprNode left;
	public ExprNode right;
	public InNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}
}
