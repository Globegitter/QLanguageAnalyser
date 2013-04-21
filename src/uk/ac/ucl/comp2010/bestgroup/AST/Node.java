package uk.ac.ucl.comp2010.bestgroup.AST;

public abstract class Node {
	public int lineNumber;
	public int charNumber;
	
	public void setPosition(int l, int c) {
		lineNumber = l+1;
		charNumber = c+1;
	}
}
