package uk.ac.ucl.comp2010.bestgroup;
import java.util.List;
import java.util.ListIterator;

import com.sun.org.apache.xpath.internal.operations.Bool;

import uk.ac.ucl.comp2010.bestgroup.AST.*;

public class SemanticsVisitor extends Visitor{
	@Override
	public Object visit(IntNode node) {
		return "int";
	}
	
	@Override
	public Object visit(NumericOperationNode node) {
		String leftType = (String)visit(node.left);
		String rightType = (String)visit(node.right);
		if(leftType == "int" && rightType == "int") {
			return "int";
		} else if(leftType == "int" && rightType == "float" || leftType == "float" && rightType == "int" || leftType == "float" && rightType == "float"){
			return "float";
		} else {
			System.out.println("Cannot understand: " + leftType + " " + node.op + " " + rightType);
			return null;
		}
	}
	
}
