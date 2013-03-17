package uk.ac.ucl.comp2010.bestgroup.AST;

public class FunctionCallStatementNode extends StatementNode{
	FunctionCallNode f;
	public FunctionCallStatementNode(FunctionCallNode f) {
		this.f = f;
	}
}
