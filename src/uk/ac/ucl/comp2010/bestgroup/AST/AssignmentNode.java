package uk.ac.ucl.comp2010.bestgroup.AST;

public class AssignmentNode extends StatementNode{
	public String variable;
	public ExprNode value;
	public AssignmentNode(String variable, ExprNode value) {
		this.variable = variable;
		this.value = value;
	}
}
