package uk.ac.ucl.comp2010.bestgroup.AST;


public class StringNode extends SequenceNode{
	public StringNode(String str) {
		super(null);
		
		char[] charArray = str.toCharArray();
		for(int i=0; i<charArray.length; i++) {
			elements.addLast(new CharNode(charArray[i]));
		}
	}
}
