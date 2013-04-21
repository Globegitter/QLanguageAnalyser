package uk.ac.ucl.comp2010.bestgroup.AST;

public class LengthNode extends ExprNode{
	/**
	 * @uml.property  name="sequence"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode sequence;
	public LengthNode(ExprNode sequence) {
		this.sequence = sequence;
	}
}
