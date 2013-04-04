package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class FuncDeclNode extends DeclNode {
	public String id;
	public LinkedList<VarTypeNode> args;
	public String type;
	public BlockNode body;
	
	public FuncDeclNode(String id, LinkedList<VarTypeNode> args, String type, BlockNode body) {
		this.id = id;
		this.args = args;
		this.type = type;
		this.body = body;
	}
}
