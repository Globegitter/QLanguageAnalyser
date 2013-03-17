package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public abstract class SequenceNode extends ExprNode{
	public LinkedList<ExprNode> elements;
	
	public SequenceNode(LinkedList<ExprNode> elements) {
		this.elements = elements;
	}
}
