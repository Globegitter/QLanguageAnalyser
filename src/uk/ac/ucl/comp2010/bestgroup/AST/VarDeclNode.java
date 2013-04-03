package uk.ac.ucl.comp2010.bestgroup.AST;

public class VarDeclNode extends DeclNode {
	public VarTypeNode var;
	public Object value;
	
	public VarDeclNode(VarTypeNode var) {
		this(var, null);
	}
	
	public VarDeclNode(VarTypeNode var, Object value) {
		this.var = var;
		this.value = value;
	}
}
