package uk.ac.ucl.comp2010.bestgroup;
import java.util.List;
import java.util.ListIterator;

import com.sun.org.apache.xpath.internal.operations.Bool;

import uk.ac.ucl.comp2010.bestgroup.AST.*;

public class CodeOutputVisitor {
	static int indent = 0;
	public static String getIndent(int d) {
		String str = "";
		for(int i=0; i<d; i++) {
			str += "  ";
		}
		return str;
	}
		
	
	public static void display(Object... args) {
		for(Object n : args) {
			display(n);
		}
	}
	
	
	
	
	
	
	public static void display(AccessorNode node) {
		displayList(".", node.path);
	}
			
	public static void display(AssignmentNode node) {
		display(node.var, " = ", node.value, ";");
	}
			
	public static void display(BlockNode node) {
		display("{", "\n", getIndent(++indent));
		displayList("\n" + getIndent(indent), node.declarations, true);
		displayList("\n" + getIndent(indent), node.statements);
		display("\n" + getIndent(--indent) + "}");
	}
		
	public static void display(BooleanOperationNode node) {
		display("(", node.left, ") " + node.op + " (", node.right, ")");
	}
	
	public static void display(BoolNode node) {
		display(node.value);
	}
	
	public static void display(CharNode node) {
		display("'" + node.value + "'");
	}
	
	public static void display(ComparisonNode node) {
		display("(", node.left, ") " + node.op + " (", node.right, ")");
	}
	
	public static void display(ConcatNode node) {
		display("(", node.left, ") :: (", node.right, ")");
	}
	
	public static void display(DatatypeDeclNode node) {
		display("tdef " + node.id + " : ");
		displayList(", ", node.fields);
		display(";");
	}
	
	public static void display(EqualsNode node) {
		display("(", node.left, ") == (", node.right, ")");
	}
	
	public static void display(FloatNode node) {
		display(node.value);
	}
	
	public static void display(FuncCallExprNode node) {
		display(node.id + "(");
		displayList(", ", node.args);
		display(")");
	}
	
	public static void display(FuncCallStmtNode node) {
		display(node.call, ";");
	}
	
	public static void display(FuncDeclNode node) {
		display("fdef " + node.id + " (");
		displayList(", ", node.args);
		display(") : " + node.type + " ", node.body);
	}
	
	public static void display(IfNode node) {
		display("if (", node.condition, ")", node.true_block);
		if(node.false_block != null)
			display(" else ", node.false_block);		
	}
	
	public static void display(IndexNode node) {
		display(node.var, "(", node.index, ")");
	}
	
	public static void display(IndexRangeNode node) {
		display(node.var, "(");
		if(node.from != null)
			display(node.from, ":");
		if(node.to != null)
			display(node.to);
		display(")");
	}
	
	public static void display(InNode node) {
		display(node.left, " in ", node.right);
	}
	
	public static void display(IntNode node) {
		display(node.value);
	}
	
	public static void display(LengthNode node) {
		display("len(", node.sequence, ")");
	}
	
	public static void display(NegativeNode node) {
		display("-(", node.val, ")");
	}
	
	public static void display(NotNode node) {
		display("!(", node.val, ")");
	}
	
	public static void display(NumericOperationNode node) {
		display("(", node.left, ") " + node.op + " (", node.right, ")");
	}
	
	public static void display(ProgramNode node) {
		displayList("\n", node.declarations, true);
		display("\n", node.main);
	}
	
	public static void display(RepeatNode node) {
		display("repeat ", node.loop, " until (", node.condition, ");");
	}
	
	public static void display(ReturnNode node) {
		if(node.expr == null) {
			display("return;");
		} else {
			display("return ", node.expr, ";");
		}
	}
	
	public static void display(SequenceNode node) {
		display("[");
		displayList(", ", node.elements);
		display("]");
	}
	
	public static void display(StringNode node) {
		display("\"" + node.str + "\"");
	}
	
	public static void display(VarDeclNode node) {
		display(node.var);
		if(node.value != null){
			display(" = ");
			displayList(", ", node.value);
		}
		display(";");
	}
	
	public static void display(VarTypeNode node) {
		display(node.id + ":" + node.type);
	}
	
	public static void display(WhileNode node) {
		display("while (", node.condition, ") do ", node.loop);
	}
	
	
	
	// --------------

	
	
	public static void displayList(String separator, List l) {
		ListIterator li = l.listIterator();
		while(li.hasNext()) {
			if(li.hasPrevious())
				display(separator);
			Object n = li.next();
			display(n);
		}
	}
	
	public static void displayList(String separator, List l, boolean includeAfter) {
		displayList(separator, l);
		if(!l.isEmpty() && includeAfter) {
			display(separator);
		}
	}

	




	
	
	
	
	
	
	public static void display(Object node) {
		if(AccessorNode.class.isInstance(node)) {
			display((AccessorNode)node);
		} else if(AssignmentNode.class.isInstance(node)) {
			display((AssignmentNode)node);
		} else if(BlockNode.class.isInstance(node)) {
			display((BlockNode)node);
		} else if(BooleanOperationNode.class.isInstance(node)) {
			display((BooleanOperationNode)node);
		} else if(BoolNode.class.isInstance(node)) {
			display((BoolNode)node);
		} else if(CharNode.class.isInstance(node)) {
			display((CharNode)node);
		} else if(ComparisonNode.class.isInstance(node)) {
			display((ComparisonNode)node);
		} else if(ConcatNode.class.isInstance(node)) {
			display((ConcatNode)node);
		} else if(DatatypeDeclNode.class.isInstance(node)) {
			display((DatatypeDeclNode)node);
		} else if(EqualsNode.class.isInstance(node)) {
			display((EqualsNode)node);
		} else if(FloatNode.class.isInstance(node)) {
			display((FloatNode)node);
		} else if(FuncCallExprNode.class.isInstance(node)) {
			display((FuncCallExprNode)node);
		} else if(FuncCallStmtNode.class.isInstance(node)) {
			display((FuncCallStmtNode)node);
		} else if(FuncDeclNode.class.isInstance(node)) {
			display((FuncDeclNode)node);
		} else if(IfNode.class.isInstance(node)) {
			display((IfNode)node);
		} else if(IndexNode.class.isInstance(node)) {
			display((IndexNode)node);
		} else if(IndexRangeNode.class.isInstance(node)) {
			display((IndexRangeNode)node);
		} else if(InNode.class.isInstance(node)) {
			display((InNode)node);
		} else if(IntNode.class.isInstance(node)) {
			display((IntNode)node);
		} else if(LengthNode.class.isInstance(node)) {
			display((LengthNode)node);
		} else if(NegativeNode.class.isInstance(node)) {
			display((NegativeNode)node);
		} else if(NotNode.class.isInstance(node)) {
			display((NotNode)node);
		} else if(NumericOperationNode.class.isInstance(node)) {
			display((NumericOperationNode)node);
		} else if(ProgramNode.class.isInstance(node)) {
			display((ProgramNode)node);
		} else if(RepeatNode.class.isInstance(node)) {
			display((RepeatNode)node);
		} else if(ReturnNode.class.isInstance(node)) {
			display((ReturnNode)node);
		} else if(SequenceNode.class.isInstance(node)) {
			if(StringNode.class.isInstance(node))
				display((StringNode)node);
			else
				display((SequenceNode)node);
		} else if(VarDeclNode.class.isInstance(node)) {
			display((VarDeclNode)node);
		} else if(VarTypeNode.class.isInstance(node)) {
			display((VarTypeNode)node);
		} else if(WhileNode.class.isInstance(node)) {
			display((WhileNode)node);
		} else if(Node.class.isInstance(node)){
			System.out.print("<<" + node.getClass().getSimpleName() + ":" + node + ">>");
		} else {
			System.out.print(node);
		}
	}

}
