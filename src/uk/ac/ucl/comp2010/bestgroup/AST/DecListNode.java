package uk.ac.ucl.comp2010.bestgroup.AST;

import java.util.LinkedList;

public class DecListNode extends Node{
	public LinkedList<DecNode> declarations;
	
	public DecListNode(DecNode dec, DecListNode rest) {
		if(rest == null)
			declarations = new LinkedList<DecNode>();
		else
			declarations = rest.declarations;
		
		declarations.addFirst(dec);
	}
}
