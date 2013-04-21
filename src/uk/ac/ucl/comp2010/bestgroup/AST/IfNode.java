package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class IfNode extends StatementNode{
	/**
	 * @uml.property  name="condition"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode condition;
	/**
	 * @uml.property  name="true_block"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public BlockNode true_block;
	/**
	 * @uml.property  name="false_block"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
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
