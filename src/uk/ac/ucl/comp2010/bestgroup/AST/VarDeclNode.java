package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class VarDeclNode extends DeclNode {
	public VarTypeNode var;
	public LinkedList<ExprNode> value;
	
	public VarDeclNode(VarTypeNode var, LinkedList<ExprNode> value) {
		this.var = var;
		this.value = value;
	}
}
