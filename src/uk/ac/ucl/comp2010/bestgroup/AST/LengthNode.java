package uk.ac.ucl.comp2010.bestgroup.AST;

public class LengthNode extends ExprNode{
	public ExprNode sequence;
	public LengthNode(ExprNode sequence) {
		this.sequence = sequence;
	}
}
