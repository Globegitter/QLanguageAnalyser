package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class ListNode extends SequenceNode{
	public ListNode(LinkedList<ExprNode> elements) {
		super(elements);
	}
}
