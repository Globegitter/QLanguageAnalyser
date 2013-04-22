package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;


public class SequenceNode extends ExprNode{
	/**
	 * @uml.property  name="elements"
	 */
	public LinkedList<ExprNode> elements;
	public boolean isTuple = false;
		
	public SequenceNode(LinkedList<ExprNode> elements, boolean isTuple) {
		this.elements = elements;
		this.isTuple = isTuple;
	}
	
	public SequenceNode(String str) {
		this.elements = new LinkedList<ExprNode>();
		char[] charArray = str.toCharArray();
		for(int i=0; i<charArray.length; i++) {
			elements.addLast(new CharNode(charArray[i]));
		}
	}
}
