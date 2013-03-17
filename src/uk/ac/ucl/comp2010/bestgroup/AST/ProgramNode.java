package uk.ac.ucl.comp2010.bestgroup.AST;

public class ProgramNode extends Node{
	public DecListNode decList;
	public ProgramNode(DecListNode decList, Object statements) {
		this.decList = decList;
	}
}
