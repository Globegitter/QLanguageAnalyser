package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class FuncDeclNode extends DeclNode {
	public String id;
	public LinkedList<VarTypeNode> argList;
	public String type;
	public BlockNode body;
	
	public FuncDeclNode(String id, LinkedList<VarTypeNode> argList, String type, BlockNode body) {
		this.id = id;
		this.argList = argList;
		this.type = type;
		this.body = body;
	}
}
