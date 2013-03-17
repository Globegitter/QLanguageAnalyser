package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class TDefNode extends DecNode {
	public String id;
	public LinkedList<ArgNode> fields;
	
	public TDefNode(String id, LinkedList<ArgNode> fields) {
		this.id = id;
		this.fields = fields;
	}
	
}
