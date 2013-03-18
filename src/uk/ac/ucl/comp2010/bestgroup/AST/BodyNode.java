package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class BodyNode extends Node{
	public LinkedList<DecNode> declarations;
	public LinkedList<StatementNode> statements;
	public BodyNode(LinkedList<DecNode> declarations, LinkedList<StatementNode> statements) {
		this.declarations = declarations;
		this.statements = statements;
		if(declarations.size()>0) {
			if(ReallyDodgyAssignmentWrapper.class.isInstance(declarations.getLast())) {
				ReallyDodgyAssignmentWrapper wrapper = (ReallyDodgyAssignmentWrapper) declarations.removeLast(); 
				statements.addFirst(wrapper.a);
			}
		}
	}
}
