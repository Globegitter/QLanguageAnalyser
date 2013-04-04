package uk.ac.ucl.comp2010.bestgroup.AST;

public class ConcatNode extends ExprNode{
	public ExprNode left;
	public ExprNode right;
	public ConcatNode(ExprNode left, ExprNode right) {
		this.left = left;
		this.right = right;
	}
}
