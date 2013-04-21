package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class VarDeclNode extends DeclNode {
	/**
	 * @uml.property  name="var"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	public VarTypeNode var;
	/**
	 * @uml.property  name="value"
	 */
	public LinkedList<ExprNode> value;
	
	public VarDeclNode(VarTypeNode var, LinkedList<ExprNode> value) {
		this.var = var;
		this.value = value;
	}
}
