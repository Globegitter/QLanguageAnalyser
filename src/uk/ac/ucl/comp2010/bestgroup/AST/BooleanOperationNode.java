package uk.ac.ucl.comp2010.bestgroup.AST;

public class BooleanOperationNode extends ExprNode{
	public static final String AND = "&&";
	public static final String OR = "||";
	
	public String op;
	public ExprNode left;
	public ExprNode right;
	public BooleanOperationNode(String op, ExprNode left, ExprNode right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
}
