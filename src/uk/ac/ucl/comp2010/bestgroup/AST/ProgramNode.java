package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class ProgramNode extends Node{
	public LinkedList<DecNode> declarations;
	public BodyNode main;
	public ProgramNode(LinkedList<DecNode> declarations, BodyNode main) {
		this.declarations = declarations;
		this.main = main;
	}
}
