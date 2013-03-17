package uk.ac.ucl.comp2010.bestgroup.AST;

public class IndexRangeNode extends ExprNode{
	public String variable;
	public ExprNode from;
	public ExprNode to;
	
	public IndexRangeNode(String variable, ExprNode from, ExprNode to) {
		this.variable = variable;
		this.from = from;
		this.to = to;
	}
}
