package uk.ac.ucl.comp2010.bestgroup.AST;

public class IndexRangeNode extends ExprNode{
	public ExprNode var;
	public ExprNode from;
	public ExprNode to;
		
	public IndexRangeNode(ExprNode var, ExprNode from, ExprNode to) {
		this.var = var;
		this.from = from;
		this.to = to;
	}
}
