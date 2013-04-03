package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class WhileNode extends StatementNode{
	public ExprNode condition;
	public BlockNode loop;
		
	public WhileNode(ExprNode condition, BlockNode loop) {
		this.condition = condition;
		this.loop = loop;
	}
}
