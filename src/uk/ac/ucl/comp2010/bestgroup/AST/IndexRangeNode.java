package uk.ac.ucl.comp2010.bestgroup.AST;

public class IndexRangeNode extends ExprNode{
	/**
	 * @uml.property  name="var"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode var;
	/**
	 * @uml.property  name="from"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode from;
	/**
	 * @uml.property  name="to"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode to;
		
	public IndexRangeNode(ExprNode var, ExprNode from, ExprNode to) {
		this.var = var;
		this.from = from;
		this.to = to;
	}
}
