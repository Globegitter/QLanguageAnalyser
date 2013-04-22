package uk.ac.ucl.comp2010.bestgroup;
import java.util.*;

import uk.ac.ucl.comp2010.bestgroup.AST.*;

public class SemanticsVisitor extends Visitor{

	LinkedList<HashMap<String, DeclNode>> symbolTables;

	public void error(String err, Node node) {
		System.out.println(err + " (line " + node.lineNumber + ", col " + node.charNumber + ")");
	}

	public SemanticsVisitor() {
		symbolTables = new LinkedList<HashMap<String, DeclNode>>();
	}

	private void insert(String id, DeclNode node){
		symbolTables.getLast().put(id, node);
	}

	private void beginScope() {
		symbolTables.addLast(new HashMap<String, DeclNode>());
	}

	private void endScope(){
		symbolTables.removeLast();
	}

	//Possibly change to boolean return-type?
	private DeclNode lookup(String id){
		for(ListIterator<HashMap<String, DeclNode>> it = symbolTables.listIterator(symbolTables.size()); it.hasPrevious();){
			DeclNode declaration = it.previous().get(id);
			if(declaration != null){
				return declaration;
			}
		}
		return null;
	}

	private DeclNode lookupFirst(String id){
		return symbolTables.getFirst().get(id);
	}

	//could possibly give more detailed error description if I change it from boolean to int or string and at least 3 returns.
	/* private boolean lookupProperty(String id, String property){
    	//Looks if variable has been declared
    	DeclNode variableDecl = lookup(id);
    	//System.out.println("Entering, looking for: " + id);
    	if(variableDecl != null){
    		//System.out.println(variableDecl.toString());
    	}
    	if(variableDecl instanceof VarDeclNode){
    		//Now need to check what type it is and if it has been declared at the top.
    		String variableType = ((VarDeclNode) variableDecl).var.type;
    		//System.out.println("Found: " + variableType);
    		DeclNode customType = symbolTables.getFirst().get(variableType);
    		if(customType != null){
    			if(customType instanceof DatatypeDeclNode){
    				return true;
    			}
    		}
    	}
    	return false;
    }*/







	// -------------------- SCOPE CHECKING --------------------------

	@Override
	public Object visit(ProgramNode node){
		beginScope();
		//System.out.println("Beginning Scope, declaration size: " + node.declarations.size());
		visitList(node.declarations);
		beginScope();
		visit(node.main);
		endScope();
		endScope();
		return null;

	}

	@Override
	public Object visit(AccessorNode node) {
		String variableId = node.path.getFirst();
		DeclNode vardecl = lookup(variableId);
		if (vardecl == null && !(vardecl instanceof VarDeclNode)) {
			error("Variable " + variableId + " does not exit", node);
			return null;
		} else {
			if (node.path.size() == 1) {
				return ((VarDeclNode) vardecl).var.type;
			} else {
				String t = ((VarDeclNode) vardecl).var.type;
				DeclNode type;
				pathloop: for (int p = 0; p < node.path.size() - 1; p++) {
					type = lookupFirst(t);
					for (ListIterator<VarTypeNode> ti = ((DatatypeDeclNode) type).fields
							.listIterator(); ti.hasNext();) {
						VarTypeNode n = ti.next();
						if (n.id.equals(node.path.get(p + 1))) {
							t = n.type;
							continue pathloop;
						}
					}
					String e = node.path.getFirst();
					for (int i = 1; i <= p; i++) {
						if (i > 0) {
							e += ".";
						}
						e += node.path.get(p);
					}
					e += " (type: " + t + ") does not have property "
							+ node.path.get(p + 1);
					error(e, node);
					return null;
				}
				return t;
			}
		}
	}


	@Override
	public Object visit(DatatypeDeclNode node) {
		if (symbolTables.getFirst().containsKey(node.id)) {
			error("Can't declare " + node.id + " twice in same scope", node);
			return null;
		}		

		for (ListIterator<VarTypeNode> li = node.fields.listIterator(); li
				.hasNext();) {
			VarTypeNode n = li.next();
			if (!isType(n.type)) {
				error("Type " + n.type + " does not exist", n);
				return null;
			}
		}

		insert(node.id, node);

		return null;
		// for declaring datatypes
	}



	@Override
	public Object visit(FuncCallExprNode node) {
		DeclNode fdef = lookupFirst(node.id);
		if (fdef == null || !(fdef instanceof FuncDeclNode)) {
			error("Function " + node.id + " does not exit", node);
			return null;
		} else if (node.args.size() != ((FuncDeclNode) fdef).args.size()) {
			error("Function " + node.id + " should take "
					+ ((FuncDeclNode) fdef).args.size() + " argument(s) ("
					+ node.args.size() + " given)", node);
		} else {
			for (int i = 0; i < node.args.size(); i++) {
				String refType = (String) visit(node.args.get(i));
				String declType = (String) (((FuncDeclNode) fdef).args.get(i).type);
				if (!isSupertype(refType, declType)) {
					error("Argument " + (i + 1) + " of function " + node.id
							+ " should be of type " + declType + " (" + refType
							+ " given)", node.args.get(i));
				}
			}
		}
		return ((FuncDeclNode) fdef).type;
		// for calling functions
	}

	@Override
	public Object visit(FuncDeclNode node) {
		if (!isType(node.type) && node.type != "void") {
			error("Type " + node.type + " does not exist", node);
			return null;
		}

		if (symbolTables.getFirst().containsKey(node.id)) {
			error("Can't declare " + node.id + " twice in same scope", node);
			return null;
		}

		insert(node.id, node);

		beginScope();

		for (ListIterator<VarTypeNode> li = node.args.listIterator(); li
				.hasNext();) {
			VarTypeNode n = li.next();
			if (!isType(n.type)) {
				error("Type " + n.type + " does not exist", n);
				endScope();
				return null;
			} else {
				insert(n.id, new VarDeclNode(n, new LinkedList<ExprNode>()));
			}
		}

		visit(node.body);

		endScope();

		return null;
		// for declaring functions
	}



	@Override
	//To-do: need to check if what the variable is actually declaring, e.g. if it is calling a function, etc. exists.
	public Object visit(VarDeclNode node) {
		if (!isType(node.var.type)) {
			error("Type " + node.var.type + " does not exist", node);
			return null;
		}


		visitList(node.value);
		HashMap<String, DeclNode> latestTable = symbolTables.getLast();
		if (!latestTable.containsKey(node.var.id)) {
			latestTable.put(node.var.id, node);
		} else {
			error("Can't declare " + node.var.id + " twice in same scope", node);
		}

		return null;
		// for declaring variables
	}




	// ---------------------------- TYPE CHECKING -----------------------


	public boolean isType(String type) {
		if (type == "string" || type == "int" || type == "float"
				|| type == "bool" || type == "list" || type == "tuple") {
			return true;
		}

		DeclNode t = lookupFirst(type);

		if (t == null || !(t instanceof DatatypeDeclNode)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isSupertype(String sub, String sup) {
		if(sub == sup)
			return true;
		if(sub == "int" && sup == "float")
			return true;
		//if(sub == "string" && sup == "list")
			//return true;
		return false;
	}


	@Override
	public Object visit(BoolNode node){
		return "bool";
	}

	@Override
	public Object visit(CharNode node){
		return "char";
	}

	@Override
	public Object visit(FloatNode node){
		return "float";  	
	}
	

	@Override
	public Object visit(IntNode node) {
		return "int";
	}

	
	public Object visit(String node){
		return "string";
	}
	
	
	@Override
	public Object visit(ComparisonNode node){
		String left = (String) visit(node.left);
		String right = (String) visit(node.right);
		if(left == null || right == null) {
			return "bool";
		} else if((left.equals("int") && right.equals("int")) || (left.equals("float") && right.equals("float")) || (left.equals("bool") && right.equals("bool")) || (left.equals("int") && right.equals("float")) || (left.equals("float") && right.equals("int"))){
			return "bool";
		} else {
			error("Can't interpret <" + left + "> " + node.op + " <" + right + ">", node);
			return "bool";
		}
	}

	@Override
	public Object visit(ConcatNode node){
		String left = (String) visit(node.left);
		String right = (String) visit(node.right);
		if(left == null || right == null) {
			return null;
		} else if(left.equals("tuple") && right.equals("tuple")){
			return "tuple";
		} else if (left.equals("list") && right.equals("list")){
			return "list";
		} else if (left.equals("string") && right.equals("string")){
		    return "string";		    
		} else {
			error("Can't concatenate types " + node.left + " and " + node.right, node);
			return null;
		}
	}



	@Override
	public Object visit(EqualsNode node){
		String left = (String) visit(node.left);
		String right = (String) visit(node.right);
		if(left == null || right == null) {
			return "bool";
		} else if (isSupertype(left, right)){
			return "bool";
		} else if(isSupertype(right, left)){
			return "bool";
		} else {
			error("Can't interpret <" + left + "> " + node.op + " <" + right + ">", node);
			return null;
		}
	}

	@Override
	public Object visit(IfNode node) {
		if(visit(node.condition) != "bool") {
			error("If condition must be a boolean", node.condition);
		}
		visit(node.true_block);
		if(node.false_block != null)
			visit(node.false_block);		
		return null;
	}


	@Override
	public Object visit(NumericOperationNode node) {
		String left = (String) visit(node.left);
		String right = (String) visit(node.right);
		if(left == null || right == null) {
			return null;
		} else if(left == "int" && right == "int") {
			return "int";
		} else if(left == "int" && right == "float" || left == "float" && right == "int" || left == "float" && right == "float"){
			return "float";
		} else {
			error("Can't interpret <" + left + "> " + node.op + " <" + right + ">", node);
			return null;
		}
	}

}
