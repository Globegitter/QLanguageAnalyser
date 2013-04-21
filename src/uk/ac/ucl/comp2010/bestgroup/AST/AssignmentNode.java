package uk.ac.ucl.comp2010.bestgroup.AST;

public class AssignmentNode extends StatementNode{
	/**
	 * @uml.property  name="var"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public AccessorNode var;
	/**
	 * @uml.property  name="value"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode value;
	
	public AssignmentNode(AccessorNode accessor, ExprNode value) {
		this.var = accessor;
		this.value = value;
	}
}
