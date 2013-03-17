package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class ProgramNode extends Node{
	public LinkedList<DecNode> decList;
	public ProgramNode(LinkedList<DecNode> decList, Object statements) {
		this.decList = decList;
	}
}
