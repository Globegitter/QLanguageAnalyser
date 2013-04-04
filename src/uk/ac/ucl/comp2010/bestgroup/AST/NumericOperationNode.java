package uk.ac.ucl.comp2010.bestgroup.AST;

public class NumericOperationNode extends ExprNode{
	public static String PLUS = "+";
	public static String MINUS = "-";
	public static String MULTIPLY = "*";
	public static String DIVIDE = "/";
	public static String POWER = "^";
	
	public String op;
	public ExprNode left;
	public ExprNode right;
	public NumericOperationNode(String op, ExprNode left, ExprNode right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
}
