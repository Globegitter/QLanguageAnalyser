package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class FuncCallStmtNode extends StatementNode{
	/**
	 * @uml.property  name="call"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public FuncCallExprNode call;
	
	public FuncCallStmtNode(FuncCallExprNode call) {
		this.call = call;
	}
}
