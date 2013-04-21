package uk.ac.ucl.comp2010.bestgroup.AST;

public class IndexNode extends ExprNode{
	/**
	 * @uml.property  name="var"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode var;
	/**
	 * @uml.property  name="index"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode index;
		
	public IndexNode(ExprNode var, ExprNode index) {
		this.var = var;
		this.index = index;
	}
}
