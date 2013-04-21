package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class ProgramNode extends Node{
	/**
	 * @uml.property  name="declarations"
	 */
	public LinkedList<DeclNode> declarations;
	/**
	 * @uml.property  name="main"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public BlockNode main;
	
	public ProgramNode(BlockNode main) {
		this(new LinkedList<DeclNode>(), main);
	}
	
	public ProgramNode(LinkedList<DeclNode> declarations, BlockNode main) {
		this.declarations = declarations;
		this.main = main;
	}
}
