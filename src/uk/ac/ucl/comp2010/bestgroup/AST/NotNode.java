package uk.ac.ucl.comp2010.bestgroup.AST;

public class NotNode extends ExprNode{
	public ExprNode val;
	public NotNode(ExprNode val) {
		this.val = val;
	}
}
