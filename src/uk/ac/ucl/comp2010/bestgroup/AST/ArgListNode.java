package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class ArgListNode extends Node{
	public LinkedList<ArgNode> args;
	
	public ArgListNode() {
		args = new LinkedList<ArgNode>();
	}
	
	public ArgListNode(ArgNode arg, ArgListNode rest) {
		if(rest == null)
			args = new LinkedList<ArgNode>();
		else
			args = rest.args;
		
		args.addFirst(arg);
	}
}
