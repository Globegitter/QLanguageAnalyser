package uk.ac.ucl.comp2010.bestgroup.AST;

public class AssignmentNode extends StatementNode{
	public AccessorNode var;
	public ExprNode value;
	
	public AssignmentNode(AccessorNode accessor, ExprNode value) {
		this.var = accessor;
		this.value = value;
	}
}
