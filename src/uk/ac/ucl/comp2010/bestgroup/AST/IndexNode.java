package uk.ac.ucl.comp2010.bestgroup.AST;

public class IndexNode extends ExprNode{
	public ExprNode var;
	public ExprNode index;
		
	public IndexNode(ExprNode var, ExprNode index) {
		this.var = var;
		this.index = index;
	}
}
