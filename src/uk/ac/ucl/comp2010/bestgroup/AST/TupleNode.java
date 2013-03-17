package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class TupleNode extends SequenceNode{
	public TupleNode(LinkedList<ExprNode> elements) {
		super(elements);
	}
}
