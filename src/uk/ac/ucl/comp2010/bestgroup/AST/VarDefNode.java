package uk.ac.ucl.comp2010.bestgroup.AST;

public class VarDefNode extends DecNode {
	public String id;
	public String type;
	public Object value;
	public VarDefNode(String id, String type) {
		this(id, type, null);
	}
	
	public VarDefNode(String id, String type, Object value) {
		this.id = id;
		this.type = type;
		this.value = value;
	}
}
