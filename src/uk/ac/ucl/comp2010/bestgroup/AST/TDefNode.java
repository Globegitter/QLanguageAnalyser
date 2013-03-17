package uk.ac.ucl.comp2010.bestgroup.AST;

public class TDefNode extends DecNode {
	public String id;
	public ArgListNode fields;
	
	public TDefNode(String id, ArgListNode fields) {
		this.id = id;
		this.fields = fields;
	}
	
}
