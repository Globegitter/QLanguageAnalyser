package uk.ac.ucl.comp2010.bestgroup.AST;


public class ReturnNode extends StatementNode{
	public ExprNode value;
	
	public ReturnNode(ExprNode value) {
		this.value = value;
	}
}
