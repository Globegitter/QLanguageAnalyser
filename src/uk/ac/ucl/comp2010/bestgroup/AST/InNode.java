package uk.ac.ucl.comp2010.bestgroup.AST;

public class InNode extends ExprNode{
	ExprNode needle;
	ExprNode haystack;
	public InNode(ExprNode needle, ExprNode haystack) {
		this.needle = needle;
		this.haystack = haystack;
	}
}
