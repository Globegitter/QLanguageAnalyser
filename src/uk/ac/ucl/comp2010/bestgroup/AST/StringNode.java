package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;


public class StringNode extends SequenceNode{
	public String str;
	
	public StringNode(String str) {
		super(str);
		this.str = str;
	}
}
