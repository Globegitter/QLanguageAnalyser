package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class FuncCallStmtNode extends StatementNode{
	public String function;
	public LinkedList<ExprNode> args;
	
	public FuncCallStmtNode(String function, LinkedList<ExprNode> args) {
		this.function = function;
		this.args = args;
	}
}
