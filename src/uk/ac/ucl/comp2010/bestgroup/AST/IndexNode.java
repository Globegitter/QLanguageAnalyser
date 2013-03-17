package uk.ac.ucl.comp2010.bestgroup.AST;

public class IndexNode extends ExprNode{
	public String variable;
	public ExprNode index;
	public IndexNode(String variable, ExprNode index) {
		this.variable = variable;
		this.index = index;
	}
}
