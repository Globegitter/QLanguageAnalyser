package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;


public class StringNode extends SequenceNode{
	/**
	 * @uml.property  name="str"
	 */
	public String str;
	
	public StringNode(String str) {
		super(str);
		this.str = str;
	}
}
