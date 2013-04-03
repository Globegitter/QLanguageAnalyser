package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class IfNode extends StatementNode{
	public ExprNode condition;
	public BlockNode true_block;
	public BlockNode false_block;
	
	public IfNode(ExprNode condition, BlockNode true_block) {
		this(condition, true_block, null);
	}
	
	public IfNode(ExprNode condition, BlockNode true_block, BlockNode false_block) {
		this.condition = condition;
		this.true_block = true_block;
		this.false_block = false_block;
	}
}
