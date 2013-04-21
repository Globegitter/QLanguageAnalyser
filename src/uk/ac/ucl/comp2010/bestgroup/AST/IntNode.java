package uk.ac.ucl.comp2010.bestgroup.AST;

public class IntNode extends ExprNode{
	/**
	 * @uml.property  name="value"
	 */
	public int value;
	public IntNode(int value) {
		this.value = value;
	}
}
