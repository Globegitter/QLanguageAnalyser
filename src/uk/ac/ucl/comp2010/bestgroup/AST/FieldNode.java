package uk.ac.ucl.comp2010.bestgroup.AST;

public class FieldNode extends ExprNode{
	public String variable;
	public String field;
	public FieldNode(String variable, String field) {
		this.variable = variable;
		this.field = field;
	}
}
