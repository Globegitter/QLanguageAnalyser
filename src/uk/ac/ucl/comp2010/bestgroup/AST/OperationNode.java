package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.Arrays;
import java.util.LinkedList;

public class OperationNode extends ExprNode{
	public LinkedList<ExprNode> args;
	
	public OperationNode(ExprNode... args) {
		this.args = new LinkedList<ExprNode>(Arrays.asList(args));
	}
}
