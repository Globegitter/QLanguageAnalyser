package uk.ac.ucl.comp2010.bestgroup;
import java.util.List;
import java.util.ListIterator;

import com.sun.org.apache.xpath.internal.operations.Bool;

import uk.ac.ucl.comp2010.bestgroup.AST.*;

public class CodeOutputVisitor extends Visitor{
	/**
	 * @uml.property  name="indent"
	 */
	int indent = 0;

	public String getIndent(int d) {
		String str = "";
		for(int i=0; i<d; i++) {
			str += "  ";
		}
		return str;
	}

	@Override
	public Object visit(Object node) {
		if(node instanceof Node) {
			return super.visit(node);
		} else {
			System.out.print(node);
			return null;
		}
	}
	
	public Object visitList(String separator, List l) {
		ListIterator li = l.listIterator();
		while(li.hasNext()) {
			if(li.hasPrevious())
				visit(separator);
			Object n = li.next();
			visit(n);
		}
		return null;
	}

	public Object visitList(String separator, List l, boolean includeAfter) {
		visitList(separator, l);
		if(!l.isEmpty() && includeAfter) {
			visit(separator);
		}
		return null;
	}
	
	
	// -----------------------------------------------

	
	@Override
	public Object visit(AccessorNode node) {
		visitList(".", node.path);
		return null;
	}

	@Override
	public Object visit(AssignmentNode node) {
		visit(node.var, " = ", node.value, ";");
		return null;
	}

	@Override
	public Object visit(BlockNode node) {
		visit("{", "\n", getIndent(++indent));
		visitList("\n" + getIndent(indent), node.declarations, true);
		visitList("\n" + getIndent(indent), node.statements);
		visit("\n" + getIndent(--indent) + "}");
		return null;
	}

	@Override
	public Object visit(BooleanOperationNode node) {
		visit("(", node.left, ") " + node.op + " (", node.right, ")");
		return null;
	}

	@Override
	public Object visit(BoolNode node) {
		visit(node.value);
		return null;
	}

	@Override
	public Object visit(CharNode node) {
		visit("'" + node.value + "'");
		return null;
	}

	@Override
	public Object visit(ComparisonNode node) {
		visit("(", node.left, ") " + node.op + " (", node.right, ")");
		return null;
	}

	@Override
	public Object visit(ConcatNode node) {
		visit("(", node.left, ") :: (", node.right, ")");
		return null;
	}

	@Override
	public Object visit(DatatypeDeclNode node) {
		visit("tdef " + node.id + " : ");
		visitList(", ", node.fields);
		visit(";");
		return null;
	}

	@Override
	public Object visit(EqualsNode node) {
		visit("(", node.left, ") == (", node.right, ")");
		return null;
	}

	@Override
	public Object visit(FloatNode node) {
		visit(node.value);
		return null;
	}

	@Override
	public Object visit(FuncCallExprNode node) {
		visit(node.id + "(");
		visitList(", ", node.args);
		visit(")");
		return null;
	}

	@Override
	public Object visit(FuncCallStmtNode node) {
		visit(node.call, ";");
		return null;
	}

	@Override
	public Object visit(FuncDeclNode node) {
		visit("fdef " + node.id + " (");
		visitList(", ", node.args);
		visit(") : " + node.type + " ", node.body);
		return null;
	}

	@Override
	public Object visit(IfNode node) {
		visit("if (", node.condition, ")", node.true_block);
		if(node.false_block != null)
			visit(" else ", node.false_block);		
		return null;
	}

	@Override
	public Object visit(IndexNode node) {
		visit(node.var, "(", node.index, ")");
		return null;
	}

	@Override
	public Object visit(IndexRangeNode node) {
		visit(node.var, "(");
		if(node.from != null)
			visit(node.from, ":");
		if(node.to != null)
			visit(node.to);
		visit(")");
		return null;
	}

	@Override
	public Object visit(InNode node) {
		visit(node.left, " in ", node.right);
		return null;
	}

	@Override
	public Object visit(IntNode node) {
		visit(node.value);
		return null;
	}

	@Override
	public Object visit(LengthNode node) {
		visit("len(", node.sequence, ")");
		return null;
	}

	@Override
	public Object visit(NegativeNode node) {
		visit("-(", node.expr, ")");
		return null;
	}

	@Override
	public Object visit(NotNode node) {
		visit("!(", node.expr, ")");
		return null;
	}

	@Override
	public Object visit(NumericOperationNode node) {
		visit("(", node.left, ") " + node.op + " (", node.right, ")");
		return null;
	}

	@Override
	public Object visit(ProgramNode node) {
		visitList("\n", node.declarations, true);
		visit("\n", node.main);
		return null;
	}

	@Override
	public Object visit(RepeatNode node) {
		visit("repeat ", node.loop, " until (", node.condition, ");");
		return null;
	}

	@Override
	public Object visit(ReturnNode node) {
		if(node.expr == null) {
			visit("return;");
		} else {
			visit("return ", node.expr, ";");
		}
		return null;
	}

	@Override
	public Object visit(SequenceNode node) {
		visit("[");
		visitList(", ", node.elements);
		visit("]");
		return null;
	}

	@Override
	public Object visit(StringNode node) {
		visit("\"" + node.str + "\"");
		return null;
	}
	
	@Override
	public Object visit(VarDeclNode node) {
		visit(node.var);
		if(node.value != null){
			visit(" = ");
			visitList(", ", node.value);
		}
		visit(";");
		return null;
	}

	@Override
	public Object visit(VarTypeNode node) {
		visit(node.id + ":" + node.type);
		return null;
	}

	@Override
	public Object visit(WhileNode node) {
		visit("while (", node.condition, ") do ", node.loop);
		return null;
	}

}
