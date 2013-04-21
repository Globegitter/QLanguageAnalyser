package uk.ac.ucl.comp2010.bestgroup.AST;

public class BoolNode extends ExprNode{
	/**
	 * @uml.property  name="value"
	 */
	public boolean value;
	public BoolNode(boolean value) {
		this.value = value;
	}
}
