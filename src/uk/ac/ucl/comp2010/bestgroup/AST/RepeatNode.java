package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class RepeatNode extends StatementNode{
	public ExprNode condition;
	public BlockNode loop;
		
	public RepeatNode(BlockNode loop, ExprNode condition) {
		this.condition = condition;
		this.loop = loop;
	}
}
