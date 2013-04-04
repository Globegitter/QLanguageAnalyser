package uk.ac.ucl.comp2010.bestgroup.AST;

public class NegativeNode extends ExprNode{
	public ExprNode val;
	public NegativeNode(ExprNode val) {
		this.val = val;
	}
}
