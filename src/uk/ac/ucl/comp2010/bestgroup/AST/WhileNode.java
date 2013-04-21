package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class WhileNode extends StatementNode{
	/**
	 * @uml.property  name="condition"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public ExprNode condition;
	/**
	 * @uml.property  name="loop"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public BlockNode loop;
		
	public WhileNode(ExprNode condition, BlockNode loop) {
		this.condition = condition;
		this.loop = loop;
	}
}
