package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class BlockNode extends Node{
	/**
	 * @uml.property  name="declarations"
	 */
	public LinkedList<DeclNode> declarations;
	/**
	 * @uml.property  name="statements"
	 */
	public LinkedList<StatementNode> statements;
	
	public BlockNode(LinkedList<DeclNode> declarations, LinkedList<StatementNode> statements) {
		this.declarations = declarations;
		this.statements = statements;
	}
	
	public BlockNode(LinkedList<StatementNode> statements) {
		this.declarations = new LinkedList<DeclNode>();
		this.statements = statements;
	}
}
