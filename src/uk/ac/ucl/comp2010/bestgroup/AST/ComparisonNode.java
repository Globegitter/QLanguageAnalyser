package uk.ac.ucl.comp2010.bestgroup.AST;

public class ComparisonNode extends ExprNode{
	public static String LESSTHAN = "<";
	public static String LESSTHANEQUAL = "<=";
	public static String GREATERTHAN = ">";
	public static String GREATERTHANEQUAL = ">=";
	
	public String op;
	public ExprNode left;
	public ExprNode right;
	public ComparisonNode(String op, ExprNode left, ExprNode right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
}
