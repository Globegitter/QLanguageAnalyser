package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class FDefNode extends DecNode {
	public String id;
	public LinkedList<ArgNode> argList;
	public String type;
	//public LinkedList<StatementNode> statements;
	public BodyNode body;
	
	public FDefNode(String id, LinkedList<ArgNode> argList, String type, BodyNode body) {
		this.id = id;
		this.argList = argList;
		this.type = type;
		this.body = body;
	}
}
