package uk.ac.ucl.comp2010.bestgroup.AST;

public class FDefNode extends DecNode {
	public String id;
	public ArgListNode argList;
	public String type;
	
	public FDefNode(String id, ArgListNode argList, String type) {
		this.id = id;
		this.argList = argList;
		this.type = type;
	}
}
